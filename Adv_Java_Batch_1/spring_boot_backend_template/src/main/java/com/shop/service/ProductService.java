package com.shop.service;

import java.util.List;
import java.util.Optional;

import com.shop.entities.Product;

public interface ProductService {
	List<Product> allProductsDetails();
	
	Product addNewProduct(Product product);
	
	Optional<Product> findById(Long prodId);
	
	Product removeProductById(Long prodId);
	
	Product updateProd(Long prodId);
}
