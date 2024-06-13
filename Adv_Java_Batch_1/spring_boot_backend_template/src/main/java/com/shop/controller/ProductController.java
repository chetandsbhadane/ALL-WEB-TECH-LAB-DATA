package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entities.Product;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	//depdency on service
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return service.allProductsDetails();
	}
	
	@PostMapping
	public Product addNewProduct(@RequestBody Product product) {
		
		return service.addNewProduct(product);
	}
	
	@GetMapping("{id}")
	public Optional<Product> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("{id}")
	public Product deleteProduct(@PathVariable Long id) {
		return service.removeProductById(id);
	}
	
	@PutMapping("{id}")
	public Product updateProduct(@PathVariable Long id) {
		return service.updateProd(id);
	}
}
