package com.hcl.doconnect.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.Chat;
import com.hcl.doconnect.repository.IChatRepository;
import com.hcl.doconnect.service.IChatService;
import com.hcl.doconnect.to.ChatTO;

@Service
public class ChatServiceImpl implements IChatService {
	
	@Autowired
	IChatRepository iChatRepository;

	public String saveMessage(ChatTO chat) {
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
		
		Chat chat1 = new Chat(0, chat.getSender(), chat.getReceiver(), chat.getMessage(), formattedDate);
		
		iChatRepository.save(chat1);
		
		return "Message Saved Successfully";
		
	}

	public List<Chat> getMessages(String sender, String receiver) {
		
		List<Chat> chats = iChatRepository.findMessages(sender, receiver);
		
		return chats;
	}

}
