package com.hcl.doconnect.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.doconnect.to.UserTO;
import com.hcl.doconnect.entity.User;
import com.hcl.doconnect.repository.IUserRepository;
import com.hcl.doconnect.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository iUserRepository;

	public String addUser(UserTO user) {
		
		User userCheck = iUserRepository.findByUsername(user.getUsername());
		
		if(userCheck == null)
		{
			User user1 = new User(0, user.getUsername(), user.getPassword(), user.getFullname(), user.getEmail(), user.getPhone(), user.getRole());
			
			iUserRepository.save(user1);
			
			return "User Registered Successfully";
		}
		
		return "User Already Exists";
	}

	public String updateUser(User user) {

		User userCheck = iUserRepository.findById(user.getId());
		
		if(userCheck != null)
		{
			User user1 = new User(user.getId(), user.getUsername(), user.getPassword(), user.getFullname(), user.getEmail(), user.getPhone(), user.getRole());
			
			iUserRepository.save(user1);
			
			return "User Updated Successfully";
		}
		
		return "User Not Found";
	}

	public List<User> findAllUsers() {
		
		return iUserRepository.findAll();
	}


	public String deleteUser(int userId) {
		
		User userCheck = iUserRepository.findById(userId);
		
		if(userCheck != null)
		{
			iUserRepository.deleteById(userId);

			return "Deleted Successfully";
		}
		
		return "User Not Found";
	}

	public User findUser(String username, String password) {

		User user = iUserRepository.findByUsernameAndPassword(username, password);
		
		return user;
	}

	public List<String> getAdminUsersMail() {

		List<User> users = iUserRepository.findAllByRole("admin");
		
		List<String> emails = new ArrayList<String>();
		
		for(User user : users)
		{
			emails.add(user.getEmail());
		}
		
		return emails;
	}

	public User findUserById(int id) {

		return iUserRepository.findById(id);
	}

	public List<User> findAllStudents() {

		return iUserRepository.findAllByRole("student");
	}

}
