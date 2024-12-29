package com.hcl.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.doconnect.service.IEmailService;
import com.hcl.doconnect.service.IUserService;

@RestController
public class EmailController {
	
	@Autowired
	private IEmailService iEmailService;
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/sendMail")
	public String sendMail()
	{
		
		List<String> recipientMails = iUserService.getAdminUsersMail();
		
		System.out.println(recipientMails);
		
		String status = iEmailService.sendMail(recipientMails);
		
		return status;
	}

}
