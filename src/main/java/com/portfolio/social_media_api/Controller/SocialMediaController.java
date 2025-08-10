package com.portfolio.social_media_api.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
// import org.springframework.web.server.ResponseStatusException;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;

import com.portfolio.social_media_api.Exceptions.DuplicateUsernameException;
import com.portfolio.social_media_api.Model.Account;
import com.portfolio.social_media_api.Model.Message;
import com.portfolio.social_media_api.Service.AccountService;
import com.portfolio.social_media_api.Service.MessageService;

@RestController
public class SocialMediaController {

	private AccountService accountService;
	private MessageService messageService;

	public SocialMediaController(AccountService accountService, MessageService messageService) {
		this.accountService = accountService;
		this.messageService = messageService;
	}

    @PostMapping(value = "/register")
    public ResponseEntity<Account> newAccount(@RequestBody Account account) {
		Account exists = accountService.getAccountByUsername(account.getUsername());
		if (exists == null) {
			Account savedAccount = accountService.addAccount(account);
			return ResponseEntity.status(200)
					.body(savedAccount);
			
		} else {
			throw new DuplicateUsernameException("Username already exists");
		}
    }

	@PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account account) throws AuthenticationException {
		Account aLogin = accountService.accountLogin(account.getUsername(), account.getPassword());

		return ResponseEntity.status(200).body(aLogin);
	}

	@PostMapping("messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
		Message aMessage = messageService.addMessage(message);

		return ResponseEntity.status(200).body(aMessage);
	}

	@GetMapping("messages")
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> messages = messageService.getMessages();
		return ResponseEntity.status(200).body(messages);
	}

	@GetMapping("messages/{messageId}")
    public ResponseEntity<Message> getMessageById(@PathVariable Integer messageId) {
        Message message = messageService.getMessageById(messageId);
        return ResponseEntity.status(200).body(message);
    }

	@DeleteMapping("messages/{messageId}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable Integer messageId) {
        Boolean messageDeleted = messageService.deleteMessageById(messageId);
        return messageDeleted ? ResponseEntity.status(200).body(1) :
                                ResponseEntity.status(200).build();
    }

	@PatchMapping("messages/{messageId}")
    public ResponseEntity<Integer> updateMessageById(@RequestBody String messageText, @PathVariable Integer messageId ) {
        Boolean messageUpdated = messageService.updateMessageById(messageId, messageText);
        return messageUpdated ? ResponseEntity.status(200).body(1) :
                                ResponseEntity.status(400).build();
    }

}

