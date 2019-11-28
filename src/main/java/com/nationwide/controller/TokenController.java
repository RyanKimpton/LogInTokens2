package com.nationwide.controller;
//test
import com.nationwide.Mapping.MyMapping;
import com.nationwide.dto.ResponseTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
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

	@Autowired
	private MyMapping myMapping;

	@GetMapping("/{bearerToken}")
	public ResponseTokenDTO getTokenFromBearerToken(@PathVariable String bearerToken) {
		Token token =  tokenService.findBybearerToken(bearerToken);
		return myMapping.map(token, ResponseTokenDTO.class);
	}
	
	@PostMapping("/{username}")
	public ResponseTokenDTO createToken(@PathVariable String username) {
		Token token = tokenService.createToken(username);
		return myMapping.map(token, ResponseTokenDTO.class);
	}
	@PutMapping("/{bearerToken}")
	public ResponseTokenDTO updateItem(@PathVariable String bearerToken) {
		Token token= tokenService.updateToken(bearerToken);
		return myMapping.map(token, ResponseTokenDTO.class);
	}
	@DeleteMapping("/{bearerToken}")
	public String deleteByBearerToken(@PathVariable String bearerToken) {
		tokenService.deleteByBearerToken(bearerToken);
		return "token deleted";
	}

}