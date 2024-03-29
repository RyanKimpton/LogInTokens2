package com.nationwide.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Token {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String bearerToken;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBearerToken() {
		return bearerToken;
	}
	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}
	
}

