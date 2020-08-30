package com.example.apijwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apijwt.model.Product;
import com.example.apijwt.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping(value = "/product")
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/product/name")
	public List<Product> findbyName(String name) {
		return (List<Product>) productRepository.findByName(name);
	}

	
	
	
}

// aula de github 
