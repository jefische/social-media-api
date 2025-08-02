package com.portfolio.social_media_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class SocialMediaApp {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApp.class, args);
	}

}
