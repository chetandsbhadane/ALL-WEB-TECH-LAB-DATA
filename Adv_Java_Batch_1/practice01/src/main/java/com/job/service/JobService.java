package com.job.service;

import java.util.List;

import com.job.entities.JobPosting;

public interface JobService {
	List<JobPosting> getAllJobPostings();
	
	JobPosting saveJobPost(JobPosting jobpost);
}
