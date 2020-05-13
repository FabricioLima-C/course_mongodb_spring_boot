package com.example.demo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// O ResponseEntity é um objeto que encapsula respostas http com cabeçalhos, erros dentre outros
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> findAll() {
		
		return ResponseEntity.ok().body(null);
	}
	
}
