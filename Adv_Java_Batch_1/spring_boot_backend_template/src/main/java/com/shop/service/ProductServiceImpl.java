package com.shop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Optional<Product> findById(Long prodId) {
		return repo.findById(prodId);
		
	}

	@Override
	public Product removeProductById(Long prodId) {
		Optional<Product> prodid = findById(prodId);
		System.out.println(prodid);
		if (repo.existsById(prodId)) {
			repo.deleteById(prodId);
		}
		return prodid.orElseThrow(() -> new ElementNotFoundException("Product is not found !!!!!"));
	}

	@Override
	public Product updateProd(Long prodId) {
		Optional<Product> p =  repo.findById(prodId);
		if(p.isPresent())
		{
			Product prod = p.get();
			return repo.save(prod);
		}
		return p.orElseThrow(() -> new ElementNotFoundException("Product is not found !!!!!"));
	}

}
