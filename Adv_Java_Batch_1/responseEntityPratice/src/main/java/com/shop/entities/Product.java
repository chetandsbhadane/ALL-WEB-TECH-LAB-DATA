package com.shop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

	@Column(name = "product_name", length = 20)
	private String productName;

	@Column(name = "product_price") // not null
	private double productPrice;

	@Column(name = "product_qty") // not null
	private int productQty;
	
	@ManyToOne // mandatory , o.w MappingExc
	@JoinColumn(name = "category_id", nullable = false)
	private Categories chosenCategory;
}

//insert into products values(2,'2024-06-13','2024-06-13 23:52:50.074222','BAKERY','bread',400,20)
