package com.job.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity JobPosting can have attributes like Job title, company name, location, description,
//requirements, salary, and posting date.
@Entity
@Table(name = "jobpost")
@Getter
@Setter
@ToString
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title",length = 20)
	private String jobTitle;
	
	@Column(name = "name",length = 20)
	private String compName;
	
	@Column(name = "loc",length = 20)
	private String location;
	
	@Column(name = "description",length = 20)
	private String description;
	
	@Column(name = "req",length = 20)
	@Enumerated(EnumType.STRING)
	private JobRequirement requirements;
	
	@Column(name = "sal",length = 20)
	private double salary;
	
	@CreationTimestamp //auto generate time..
	@Column(name = "posting_date")
	private LocalDate postingDate;
}
