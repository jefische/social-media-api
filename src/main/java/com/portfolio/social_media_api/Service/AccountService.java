package com.portfolio.social_media_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.social_media_api.Model.Account;
import com.portfolio.social_media_api.Repository.AccountRepository;

// import java.util.Optional;
// import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

	@Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getUserById(Integer id) {
        return accountRepository.findById(id).orElseThrow();
    }

	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}
}
