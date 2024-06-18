package com.shop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.custom_exceptions.ResourceNotFoundException;
import com.shop.dtos.ApiResponse;
import com.shop.entities.Product;
import com.shop.exception.ElementNotFoundException;
import com.shop.repository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo repo; // DI- depency bytype...
	


	@Override
	public List<Product> allProductsDetails() {

		return repo.findAll(); // it will returns the list of the products..
	}

	@Override
	public Product addNewProduct(Product product) {

		return repo.save(product);
	}

	@Override
	public Product findById(Long prodId) {
		return repo.findById(prodId).orElseThrow(() -> new ResourceNotFoundException("Invalid Product Id !!!!"));

	}

	@Override
	public ApiResponse removeProductById(Long prodId) {
		Product prodid = repo.findById(prodId)
				.orElseThrow(() -> new ElementNotFoundException("Product is not found !!!!!"));
		

		repo.deleteById(prodId);

		return new ApiResponse("Product deleted succesfully");
	}

	@Override
	public ApiResponse updateProd(Long prodId, Product product) {
		String mesg = "Updation failed!!!!";
		if (repo.existsById(prodId)) {
			repo.save(product);
			mesg = "Updated Products details !";
		} else
			throw new ResourceNotFoundException("Invalid Product ID !!!");
		return new ApiResponse(mesg);
	}

}
