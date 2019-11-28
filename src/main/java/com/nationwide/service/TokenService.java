package com.nationwide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nationwide.persistance.domain.Token;
import com.nationwide.persistance.repository.TokenRepository;

@Service
public class TokenService {
	
	@Autowired
	private TokenRepository repository;
	
	public Token findBybearerToken(String bearerToken) {
		return repository.findByBearerToken(bearerToken);
	}
	
	public Token updateToken(String bearerToken) {
		Token item2 = repository.findByToken(bearerToken);
		item2.setBearerToken(tokenGenerator());
		repository.flush();
		return item2;
	}
}
