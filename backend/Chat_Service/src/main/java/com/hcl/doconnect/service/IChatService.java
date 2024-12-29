package com.hcl.doconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.Chat;
import com.hcl.doconnect.to.ChatTO;

@Service
public interface IChatService {

	String saveMessage(ChatTO chat);

	List<Chat> getMessages(String sender, String receiver);

}
