package com.portfolio.social_media_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.portfolio.social_media_api.Repository")
public class SocialMediaApp {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApp.class, args);
	}

}
