package com.nationwide.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.persistance.domain.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	public Token findByBearerToken(String bearerToken);

	public Token findByToken(String bearerToken);
}
