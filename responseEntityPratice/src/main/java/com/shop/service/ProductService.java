package com.shop.service;

import java.util.List;
import java.util.Optional;

import com.shop.dtos.ApiResponse;
import com.shop.entities.Product;

public interface ProductService {
	List<Product> allProductsDetails();
	
	Product addNewProduct(Product product);
	
	Product findById(Long prodId);
	
	ApiResponse removeProductById(Long prodId);
	
	ApiResponse updateProd(Long prodId,Product product);
}
