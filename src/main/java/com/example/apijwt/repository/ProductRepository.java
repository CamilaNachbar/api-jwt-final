package com.example.apijwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apijwt.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByName(String name);
}
