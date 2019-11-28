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

	public Token tokenGenerator(Token oldToken){
		Token newToken = new Token();
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

		newToken.setBearerToken(sb.toString());

		newToken.setUsername(oldToken.getUsername());
		newToken.setId(oldToken.getId());

		return newToken;
	}
	
	public Token createToken(Token token) {
		return repository.saveAndFlush(token);

	}

	public Token updateToken(String bearerToken) {
		Token item2 = repository.findByBearerToken(bearerToken);
		
		Token updatedToken = new Token();
		updatedToken = tokenGenerator(item2);
		repository.saveAndFlush(updatedToken);
		return updatedToken;
	}
	public void deleteByBearerToken( String bearerToken) {
		Token t = findBybearerToken(bearerToken);
		repository.delete(t);
	}
	public class service{
		/**
		 * Takes in an {@link Account} and saves it to DB
		 */
		public Token createToken(Token token) {
			create
		}
	}
}
