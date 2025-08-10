package com.portfolio.social_media_api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.social_media_api.Model.Message;
import com.portfolio.social_media_api.Repository.AccountRepository;
import com.portfolio.social_media_api.Repository.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;
	private AccountRepository accountRepository;

	public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
		this.messageRepository = messageRepository;
		this.accountRepository = accountRepository;
	}

	public Message addMessage(Message message) {
		if (message.getMessageText().isBlank()) {
			throw new IllegalArgumentException("Message text is empty");
		}
		if (message.getMessageText().trim().length() > 255) {
			throw new IllegalArgumentException("Message text is longer than 255 character limit");
		}
		if (accountRepository.findById(message.getPostedBy()).isEmpty()) {
			throw new IllegalArgumentException("Account Id does not exist");
		}
		return messageRepository.save(message);
	}

	public List<Message> getMessages() {
		return messageRepository.findAll();
	}

	public Message getMessageById(int id) {
		return messageRepository.findById(id).orElse(null);
	}

	public boolean deleteMessageById(int id) {
		if (messageRepository.existsById(id)) {
			messageRepository.deleteById(id);
			return true;
		}
		return false;
    }

	public boolean updateMessageById(int id, String messageText) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message == null) return false;
        if (!messageText.isEmpty() && messageText.trim().length() < 255) {
            // System.out.println("message id is: " + id + ", and new message text: " + messageText);
            message.setMessageText(messageText);
            messageRepository.save(message);
            return true;
        }
        return false;
    }
}
