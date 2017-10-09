package com.example.apijwt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apijwt.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	@Override
	public List<User> findAll();
	public User findByNickname(String nickname);

}