package com.blogs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Category;
import org.hibernate.SessionFactory;


@Repository//dao layer spring bean
public class CategoryDaoImpl implements CategoryDao {
	//depcy - SF
	@Autowired //byType
	private SessionFactory factory;

	@Override
	public List<Category> getAllCategories() {
		String jpql="select c from Category c";
		return factory.getCurrentSession() 
				.createQuery(jpql,Category.class)
				.getResultList();				
	}

}
