package com.healthcare.service;

import com.healthcare.entities.Patients;

public interface PatientService {

	Patients getPatientById(Long id);
	
}
