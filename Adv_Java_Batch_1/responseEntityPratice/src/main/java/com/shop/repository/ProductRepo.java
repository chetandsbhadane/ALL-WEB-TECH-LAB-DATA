package com.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{
	
}
