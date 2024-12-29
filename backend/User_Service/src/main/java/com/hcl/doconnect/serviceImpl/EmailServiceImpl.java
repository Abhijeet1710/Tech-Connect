package com.hcl.doconnect.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.doconnect.service.IEmailService;
import com.hcl.doconnect.to.EmailTO;

@Service
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public String sendMail(List<String> emails) {

		try {
			
			for(String email : emails)
			{
			
			EmailTO emailDetails = new EmailTO();
			
			emailDetails.setSubject("A new Ques/ Ans Posted on DoConnect Application");
			
			emailDetails.setRecipient(email);
			
			emailDetails.setMessageBody("Hi, admin\n\n Kindly Approve or Reject the "
					+ "Ques/Ans posted on DoConnect Application\n\nThanks");

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setText(emailDetails.getMessageBody());
			mailMessage.setSubject(emailDetails.getSubject());

			javaMailSender.send(mailMessage);
			
			}
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

}
