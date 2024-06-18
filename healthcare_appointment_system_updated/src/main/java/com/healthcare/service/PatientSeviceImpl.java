package com.healthcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.entities.Patients;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class PatientSeviceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patients getPatientById(Long id) {
		// TODO Auto-generated method stub
		
		return  patientRepository.findById(id).orElseThrow();
	}

}
