package com.portfolio.social_media_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.social_media_api.Model.Account;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Optional<Account> findByUsername(String username);
	Optional<Account> findByUsernameAndPassword(String username, String password);	
} 
