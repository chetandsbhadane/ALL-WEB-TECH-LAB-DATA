package com.jobpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobpost.entities.JobPosting;
import com.jobpost.service.JobPostingService;

@RestController
@RequestMapping("/jobpost")
public class JobPostingController {

	@Autowired
	private JobPostingService jobPostingService; 
	
	/*
	 * Posting new Job: • Endpoint: POST /jobPostings • Request: JSON payload
	 * containing job details. • Response: Confirmation of the created job posting.
	 */
	
	@PostMapping("/jobPostings")
	public ResponseEntity<?> addJobPosting(@RequestBody JobPosting jobPost){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jobPostingService.addNewJobPost(jobPost));
		
	}
	
	/*
	 * Update Job Posting: • Endpoint: PUT /jobPostings/{jobId} • Request: Update an
	 * existing job posting by providing its unique identifier and the updated
	 * information. • Response: Confirmation of the updated job posting.
	 */
	
	@PutMapping("/jobPostings/{jobId}")
	public ResponseEntity<?> addJobPosting(@RequestBody JobPosting jobPost, Long jobId){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(jobPostingService.updateJobPost(jobPost,jobId));
		
	}
	
	/*
	 * Delete Job Posting: • Endpoint: DELETE /jobPostings/{jobId} • Request:Delete
	 * a job posting by providing its unique identifier. • Response:Confirmation of
	 * the deleted job posting.
	 */

	@DeleteMapping("/jobPostings/{jobId}")
	public ResponseEntity<?> deleteJobPosting(@RequestBody Long jobId){
		
		return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.deleteJobPost(jobId));
		
	}
	
	/*
	 * Get all Job Postings: • Endpoint: GET /jobPostings • Request: Retrieve a list
	 * of all available job postings. • Response: JSON array containing job details
	 */
	
	@GetMapping("/jobPostings")
public ResponseEntity<?> viewAllJobPosting(){
		
		return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.viewJobPost());
		
	}
	
}
