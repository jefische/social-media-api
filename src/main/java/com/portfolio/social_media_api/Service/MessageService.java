package com.portfolio.social_media_api.Service;

import org.springframework.stereotype.Service;

import com.portfolio.social_media_api.Model.Message;
import com.portfolio.social_media_api.Repository.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message addMessage(Message message) {
		if (message.getMessageText().trim().isEmpty()) {
			throw new IllegalArgumentException("Message text is empty");
		}
        return messageRepository.save(message);
    }
}
