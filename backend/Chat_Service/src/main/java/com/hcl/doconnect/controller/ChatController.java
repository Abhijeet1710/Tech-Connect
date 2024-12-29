package com.hcl.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.doconnect.entity.Chat;
import com.hcl.doconnect.service.IChatService;
import com.hcl.doconnect.to.ChatTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ChatController {
	
	@Autowired
	IChatService iChatService;
	
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestBody ChatTO chat)
	{
		String messageStatus = iChatService.saveMessage(chat);
		
		return messageStatus;
	}
	
	@GetMapping("/getMessage/{sender}/{receiver}")
	public List<Chat> getMessage(@PathVariable String sender, @PathVariable String receiver)
	{
		List<Chat> chats = iChatService.getMessages(sender, receiver);
		
		return chats;
	}

}
