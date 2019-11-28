package com.nationwide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistance.domain.Token;
import com.nationwide.persistance.repository.TokenRepository;
import com.nationwide.persistence.domain.Account;

@Service
public class TokenService {
	
	@Autowired
	private static TokenRepository repository;
	
	public Token findBybearerToken(String bearerToken) {
		return repository.findByBearerToken(bearerToken);
	}

	public static Token createToken(Token token) {
			return repository.saveAndFlush(token);
		}
	}
	
}
