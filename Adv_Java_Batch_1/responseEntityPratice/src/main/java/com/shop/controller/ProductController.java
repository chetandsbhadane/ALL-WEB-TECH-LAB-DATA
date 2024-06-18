package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dtos.ApiResponse;
import com.shop.entities.Product;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	//depdency on service
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		
		return ResponseEntity.ok(service.allProductsDetails());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewProduct(product));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(service.removeProductById(id));
	}
	
	@PutMapping("{prodId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long prodId,@RequestBody Product product) {
		System.out.println("update " + prodId);
		return ResponseEntity.status(HttpStatus.OK).body(service.updateProd(prodId,product));
	}
}
