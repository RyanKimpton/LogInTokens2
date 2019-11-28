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

	public String makeBearerToken(){
		int len = 30;

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(len);

		for (int i = 0; i < len; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
					= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}

	public Token createToken(String username) {
		Token newToken = new Token();
		newToken.setUsername(username);
		newToken.setBearerToken(makeBearerToken());
		return repository.saveAndFlush(newToken);
	}

	public Token updateToken(String bearerToken) {
		Token token = repository.findByBearerToken(bearerToken);
		token.setBearerToken(makeBearerToken());
		repository.flush();
		return token;
	}
	public void deleteByBearerToken( String bearerToken) {
		Token t = findBybearerToken(bearerToken);
		repository.delete(t);
	}
}
