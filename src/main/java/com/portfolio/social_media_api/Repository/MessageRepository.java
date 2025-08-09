package com.portfolio.social_media_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.social_media_api.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
}
