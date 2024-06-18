package com.shop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Categories extends BaseEntity{
	@Column(length = 50, unique = true)
	private String name;
	@Column(length = 200)
	private String description;
	// Category 1 ----> * BlogPost (one --> Many)
	@Enumerated(EnumType.STRING) // for the enum -
	// by def hib stores ordinals (int) , to replace it by constant names
	@Column(length = 20)
	private Category productCategory;
	
	@OneToMany(mappedBy = "chosenCategory",
			cascade = CascadeType.ALL,orphanRemoval = true
			/*,fetch=FetchType.EAGER*/)
//	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	public Categories(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
}
