package com.jobpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobpost.entities.JobPosting;

public interface JobPostRepository extends JpaRepository<JobPosting, Long> {

}
