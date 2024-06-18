package com.job.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.entities.JobPosting;
import com.job.service.JobService;

@RestController
@RequestMapping("/jobposting")
public class JobPostController {
	
	@Autowired
	private JobService service;
	
	public JobPostController() {
		System.out.println("Inside ctor..");
	}

	@GetMapping
	public ResponseEntity<?> getAllJobPosting(){
		return ResponseEntity.ok(service.getAllJobPostings());
	}
	
	@PostMapping
	public ResponseEntity<?> saveJobPosts(@RequestBody JobPosting jobPost){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveJobPost(jobPost));
	}
}
