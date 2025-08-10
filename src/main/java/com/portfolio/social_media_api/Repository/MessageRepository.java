package com.portfolio.social_media_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.social_media_api.Model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
	
}
