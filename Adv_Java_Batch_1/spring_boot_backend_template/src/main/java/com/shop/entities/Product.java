package com.shop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING) // for the enum -
	// by def hib stores ordinals (int) , to replace it by constant names
	@Column(length = 20)
	private Category productCategory;

	@Column(name = "product_name", length = 20)
	private String productName;

	@Column(name = "product_price") // not null
	private double productPrice;

	@Column(name = "product_qty") // not null
	private int productQty;
}
