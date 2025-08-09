package com.portfolio.social_media_api.Service;

// import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.social_media_api.Exceptions.InvalidAccountException;
import com.portfolio.social_media_api.Model.Account;
import com.portfolio.social_media_api.Repository.AccountRepository;

import java.util.Optional;
// import java.util.List;

import javax.naming.AuthenticationException;

@Service
public class AccountService {

    private AccountRepository accountRepository;

	@Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByUsername(String username) {
        if(accountRepository.findByUsername(username).isEmpty()) {
			return null;
		} else {
			return accountRepository.findByUsername(username).orElseThrow();
		}
    }

	public Account addAccount(Account account) {
		if (account.getUsername().isEmpty() || account.getPassword().length() <= 4) {
			throw new InvalidAccountException("Username cannot be empty and password must be at least 5 characters long.");
		}
		return accountRepository.save(account);
	}

	public Account accountLogin(String username, String password) throws AuthenticationException {
		return accountRepository.findByUsernameAndPassword(username, password)
										.orElseThrow(() -> new AuthenticationException("Invalid Login"));
	}

}
