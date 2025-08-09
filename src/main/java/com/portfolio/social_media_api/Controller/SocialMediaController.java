package com.portfolio.social_media_api.Controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;

import com.portfolio.social_media_api.Model.Account;
import com.portfolio.social_media_api.Service.AccountService;

@RestController
public class SocialMediaController {

	private AccountService accountService;

	public SocialMediaController(AccountService accountService) {
		this.accountService = accountService;
	}

    @PostMapping(value = "/register")
    public ResponseEntity<Account> newAccount(@RequestBody Account a) {
		Account add = accountService.addAccount(a);
		return ResponseEntity.status(200)
					.body(add);
    }
}

