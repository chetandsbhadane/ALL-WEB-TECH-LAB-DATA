package com.jobpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobpost.dto.ApiResonse;
import com.jobpost.entities.JobPosting;
import com.jobpost.repository.JobPostRepository;

@Service
@Transactional
public class JobPostingServiceImpl implements JobPostingService {

	@Autowired
	private JobPostRepository jobPostRepository;

	@Override
	public JobPosting addNewJobPost(JobPosting jobPost) {
		// TODO Auto-generated method stub
		return jobPostRepository.save(jobPost);
	}

	@Override
	public JobPosting updateJobPost(JobPosting jobPost, Long jobId) {
		// TODO Auto-generated method stub
		JobPosting existingJobPost = jobPostRepository.findById(jobId).orElseThrow();
		
		existingJobPost = new JobPosting(jobPost.getCompany_name(),jobPost.getDescription(),jobPost.getJob_title(),jobPost.getLocation(),jobPost.getRequirements(),jobPost.getSalary(),jobPost.getPostingDate());
		
		return existingJobPost;
	}

	@Override
	public ApiResonse deleteJobPost(Long jobId) {
		// TODO Auto-generated method stub
		String msg = "not Deleted";
		if(jobPostRepository.findById(jobId) != null) {
			jobPostRepository.deleteById(jobId);
			msg = "Deleted";
		}
		return new ApiResonse(msg);
	}

	@Override
	public List<JobPosting> viewJobPost() {
		// TODO Auto-generated method stub
		return jobPostRepository.findAll();
	} 
	
	
}
