package com.portfolio.social_media_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.social_media_api.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
} 
