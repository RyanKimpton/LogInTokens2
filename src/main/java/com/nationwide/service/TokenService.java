package com.nationwide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistance.domain.Token;
import com.nationwide.persistance.repository.TokenRepository;

@Service
public class TokenService {
	
	@Autowired
	private TokenRepository repository;
	
	public Token findBybearerToken(String bearerToken) {
		return repository.findByBearerToken(bearerToken);
	}
	
	public void deleteByBearerToken( String bearerToken) {
		Token t = findBybearerToken(bearerToken);
		repository.delete(t);
	}
}
