package com.blogs.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Category;


@Repository//dao layer spring bean
public class CategoryDaoImpl implements CategoryDao {
	//depcy - SF
	@Autowired //byType OR 
	//@PersistenceContext
	private EntityManager manager;
	/*
	 * javax.persistence.EntityManager - 
	 * super i/f of org.hibernate.Session
	 * Spring Boot , doesn't directly support hibernate APIs
	 * so using it's abstraction !
	 * SF -> EntityManagerFactory
	 * Session -> EntityManager
	 * You can directly auto wire EM in the DAO layer
	 * @AutoWired | @PersistenceContext
	 * 
	 */
	

	@Override
	public List<Category> getAllCategories() {
		String jpql="select c from Category c";
		return manager
				.createQuery(jpql,Category.class)
				.getResultList();				
	}

}
