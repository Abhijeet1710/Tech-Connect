import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import { ToastContainer, toast } from 'react-toastify';
import "react-toastify/dist/ReactToastify.css"
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router';
import { useEffect, useState } from 'react';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import '../styles/navbar.css'

const ChatComponent = () => {

    const usenavigate = useNavigate();

    const [userData, userDataChange] = useState('');
    const [username, usernameChange] = useState('');
    const [chat, chatChange] = useState('');
    const [message, messageChange] = useState('');

    const userLoggedIn = sessionStorage.getItem('username');

    const [isShown, setIsShown] = useState(false);

    const handleLogout = () => {

        usenavigate('/');
    }

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');

        console.log(username);
        console.log(role);
        if (username === '' || username === null || role !== 'student') {
            usenavigate('/');
        }

        fetch("http://localhost:8080/user/findAllStudents")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

    }, [])

    const handleSubmit = (e) => {

        e.preventDefault();

        if (validate()) {
            messageChange('');

            let sender = sessionStorage.getItem('username');
            let receiver = username;

            fetch("http://localhost:8082/getMessage/" + sender + "/" + receiver)
                .then((res) => {
                    return res.json();
                }).then((resp) => {
                    console.log(resp);
                    chatChange(resp);
                }).catch((err) => {
                    console.log(err.message);
                })

            setIsShown(true);
        }

    }

    const validate = () => {

        let result = true;
        if (username === '' || username === null) {
            result = false;
            toast('Please Select Username');
            setIsShown(false);

        }

        return result;
    }

    async function handleMessageSubmit(e) {

        e.preventDefault();

        if (isValidate()) {
            let sender = sessionStorage.getItem('username');
            let receiver = username;
            let messageData = { sender, receiver, message };

            console.log('sender is : ' + sender);
            console.log('receiver is : ' + receiver);

            await fetch("http://localhost:8082/sendMessage", {
                method: "POST",
                headers: { 'content-type': 'application/json' },
                body: JSON.stringify(messageData)
            }).then((res) => {
                console.log('inside sendmessage');

                console.log('Data saved Successfully');
                toast('Message Sent Succesfully');
            }).catch((err) => {
                console.log('Failed' + err.message);
                toast('Message not Sent');
            });

            fetch("http://localhost:8082/getMessage/" + sender + "/" + receiver)
                .then((res) => {
                    return res.json();
                }).then((resp) => {
                    console.log('inside getmessage');
                    console.log(resp);
                    chatChange(resp);
                }).catch((err) => {
                    console.log(err.message);
                })

            messageChange('');
        }

    }

    const isValidate = () => {

        let result = true;
        if (message === '' || message === null) {
            result = false;
            toast('Please Enter Message')
        }

        return result;
    }

    return (
        <>
            <Navbar bg="light" expand="lg" className='container'>
                <Container>
                    <Navbar.Brand className='navbarHeading'>Student-Dashboard</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Link to='/studentHome'><Button variant="secondary">Home</Button></Link>&ensp;
                            <Link to='/askQues'><Button variant="secondary">Ask Question</Button></Link>&ensp;
                            <Link to='/qna'><Button variant="secondary">QnA</Button></Link>&ensp;
                            <Link to='/chat'><Button variant="info">Chat</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <br />
            <Form onSubmit={handleSubmit}>
                <center><Form.Select aria-label="Default select example" style={{ maxWidth: '20%' }} onChange={(e) => {
                    const username1 = e.target.value;
                    usernameChange(username1);
                    if (username1 === '' || username1 === null) {
                        setIsShown(false);
                    }
                }}>
                    <option value="" >Select User</option>
                    {
                        userData && userData.map(item => (

                            userLoggedIn !== item.username && (
                                <option key={item.id} value={item.username}>{item.username}</option>

                            )
                        ))
                    }
                </Form.Select>
                </center>
                <br />
                <center><Button type='submit' style={{ display: 'inline' }}>Submit</Button></center>
            </Form>
            {isShown && (
                <div>
                    <Card style={{ width: '30rem', maxHeight: '300px', backgroundColor: 'beige', overflowY: "auto", overflow: 'auto', display: 'flex', flexDirection: 'column-reverse' }} className="card">
                        <Card.Body>

                            {
                                chat && chat.map(item => (
                                    <div>
                                        {
                                            userLoggedIn === item.sender ?
                                                <div style={{ textAlign: 'right', fontSize: '22px', fontWeight: '600', backgroundColor: 'lightgreen', borderRadius: '5px', marginLeft: '150px' }}>{item.message} &ensp;</div>
                                                :
                                                <div style={{ textAlign: 'left', fontSize: '22px', fontWeight: '600', backgroundColor: 'white', borderRadius: '5px', marginRight: '150px' }}>&ensp; {item.message}</div>
                                        }
                                        {
                                            userLoggedIn === item.sender ?
                                                <div style={{ textAlign: 'right', fontSize: '15px', fontWeight: '600' }}>{item.date}</div>
                                                :
                                                <div style={{ textAlign: 'left', fontSize: '15px', fontWeight: '600' }}>{item.date}</div>
                                        }

                                    </div>
                                ))
                            }
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '30rem', height: '40px' }}>
                        <Form onSubmit={handleMessageSubmit}>
                            <Row>
                                <Col xs={10}><Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                                    <Form.Control type="text" placeholder="Enter your Message" value={message} onChange={e => messageChange(e.target.value)} />
                                </Form.Group>
                                </Col>
                                <Col>
                                    <Button variant="primary" type='submit'><i className='arrow right'></i></Button>
                                </Col>
                            </Row>
                        </Form>
                    </Card>
                </div>
            )}

            <ToastContainer />
        </>
    )
}

export default ChatComponent;