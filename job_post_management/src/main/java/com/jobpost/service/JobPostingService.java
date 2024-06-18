package com.jobpost.service;

import java.util.List;

import com.jobpost.dto.ApiResonse;
import com.jobpost.entities.JobPosting;

public interface JobPostingService {

	JobPosting addNewJobPost(JobPosting jobPost);

	 JobPosting updateJobPost(JobPosting jobPost, Long jobId);

	ApiResonse deleteJobPost(Long jobId);

	List<JobPosting> viewJobPost();

	
	
}
