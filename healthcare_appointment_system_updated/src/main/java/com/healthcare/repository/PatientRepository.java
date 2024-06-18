package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.Patients;

public interface PatientRepository extends JpaRepository<Patients, Long>{

}
