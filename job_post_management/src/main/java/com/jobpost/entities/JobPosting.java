package com.jobpost.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JobPosting {
//Job title, company name, location, description, requirements, salary, and posting date
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long posting_id;
	
	private String job_title;
	private String company_name;
	private String location;
	private String description;
	private String requirements;
	private int salary;
	private LocalDate postingDate;
	
	public JobPosting(String job_title, String company_name, String location, String description, String requirements,
			int salary, LocalDate postingDate) {
		super();
		this.job_title = job_title;
		this.company_name = company_name;
		this.location = location;
		this.description = description;
		this.requirements = requirements;
		this.salary = salary;
		this.postingDate = postingDate;
	}
	
	
	
}
