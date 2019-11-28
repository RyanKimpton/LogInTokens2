package com.nationwide.controller;
//test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PutMapping;
>>>>>>> b3d1a2fe536c1304a1036cb92ee947ff0dc1d96b
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.persistance.domain.Token;
import com.nationwide.service.TokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {
//comment
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/{bearerToken}")
	public Token getTokenFromBearerToken(@PathVariable String bearerToken) {
		return tokenService.findBybearerToken(bearerToken);
	}
	
<<<<<<< HEAD
	@PostMapping
	public Token createToken(@RequestBody Token token) {
		return TokenService.createToken(token);
=======
	@PutMapping("/{bearerToken}")
	public Token updateItem(@PathVariable String bearerToken) {
		Token newToken = tokenService.updateToken(bearerToken);
		return newToken;
	}
	@DeleteMapping("/{bearerToken}")
	public String deleteByBearerToken(@PathVariable String bearerToken) {
		tokenService.deleteByBearerToken(bearerToken);
		return "token deleted";
>>>>>>> b3d1a2fe536c1304a1036cb92ee947ff0dc1d96b
	}

}