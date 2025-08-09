package com.portfolio.social_media_api.Exceptions;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAndErrorController {
	
	@ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<String> handleDuplicateUsername(DuplicateUsernameException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<String> handleInvalidAccount(InvalidAccountException ex) {
		return ResponseEntity.status(400).body(ex.getMessage());
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleInvalidLogin(AuthenticationException ex) {
		return ResponseEntity.status(401).body(ex.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleInvalidMessage(IllegalArgumentException ex) {
		return ResponseEntity.status(400).body(ex.getMessage());
	}
}
