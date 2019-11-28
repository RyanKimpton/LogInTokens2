package com.nationwide.controller;
//test
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
	
	@GetMapping("/{bearerToken}")
	public ResponseTokenDTO getTokenFromBearerToken(@PathVariable String bearerToken) {
		Token token =  tokenService.findBybearerToken(bearerToken);
		ResponseTokenDTO response = new ResponseTokenDTO();
		response.setUsername(token.getUsername());
		response.setBearerToken(token.getBearerToken());
		return response;
	}
	
	@PostMapping("/{username}")
	public ResponseTokenDTO createToken(@PathVariable String username) {
		Token token = tokenService.createToken(username);
		ResponseTokenDTO response = new ResponseTokenDTO();
		response.setUsername(token.getUsername());
		response.setBearerToken(token.getBearerToken());
		return response;
	}
	@PutMapping("/{bearerToken}")
	public ResponseTokenDTO updateItem(@PathVariable String bearerToken) {
		Token token= tokenService.updateToken(bearerToken);
		ResponseTokenDTO response = new ResponseTokenDTO();
		response.setUsername(token.getUsername());
		response.setBearerToken(token.getBearerToken());
		return response;
	}
	@DeleteMapping("/{bearerToken}")
	public String deleteByBearerToken(@PathVariable String bearerToken) {
		tokenService.deleteByBearerToken(bearerToken);
		return "token deleted";
	}

}