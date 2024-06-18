package com.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.job.Repositories.JobRepo;
import com.job.entities.JobPosting;

@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	//inject dependency..
	@Autowired
	private JobRepo repo;

	@Override
	public List<JobPosting> getAllJobPostings() {
		return repo.findAll();
	}

	@Override
	public JobPosting saveJobPost(JobPosting jobpost) {
		return repo.save(jobpost);
	}
	

}
