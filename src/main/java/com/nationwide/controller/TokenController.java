package com.nationwide.controller;
//test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.persistance.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/{bearerToken}")
	public Token getTokenFromBearerToken(@PathVariable String bearerToken) {
		return tokenService.findBybearerToken(bearerToken);
	}
	
	@DeleteMapping("/{bearerToken}")
	public String deleteByBearerToken(@PathVariable String bearerToken) {
		tokenService.deleteByBearerToken(bearerToken);
		return "token deleted";
	}

}