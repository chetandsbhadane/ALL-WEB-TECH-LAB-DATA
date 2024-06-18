package com.job.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entities.JobPosting;

public interface JobRepo extends JpaRepository<JobPosting, Long>{

}
