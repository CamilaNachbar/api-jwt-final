package com.example.apijwt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apijwt.model.User;
import com.example.apijwt.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping(value = "")
	public User login(@RequestBody User user) {
		return userRepository.findByNickname(user.nickname);
	}
}
