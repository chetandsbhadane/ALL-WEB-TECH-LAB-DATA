package com.shop.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // to tell JPA/Hiberanate -no table creation , it's common base class to inherit
//other entities
@Getter
@Setter
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	
	@CreationTimestamp //to auto generate creation date
	@Column(name="creation_date")
	private LocalDate creationDate;
	@UpdateTimestamp //to auto generate updation datetime(TS)
	@Column(name="updation_ts")
	private LocalDateTime updationTimeStamp;

}
