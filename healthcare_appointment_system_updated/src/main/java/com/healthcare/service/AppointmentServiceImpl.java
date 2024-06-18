package com.healthcare.service;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dto.ApiResponse;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Patients;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.PatientRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PatientRepository patientRepository; 
	
	
	@Override
	public Appointment createAppointment(Appointment newAppointment,Long patient_id) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		System.out.println("Patient id ---->>>>>"+patient_id);
		Patients patient = patientRepository.findById(newAppointment.getPatient().getPatient_id()).orElseThrow(()->new RuntimeException("Patient not found"));
//		if (patient ==null) {
//			throw new RuntimeException("PAtient is null");
//		}
		
		newAppointment.setPatient(patient);
//		patient.addAppointment(newAppointment);
		return appointmentRepository.save(newAppointment);
	}

	@Override
	public Optional<Appointment> viewAppointments(Long patient_id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(patient_id); 
	}

	@Override
	public ApiResponse cancelAppointment(Long id) {
		// TODO Auto-generated method stub
		String msg = "Cancellation Failed";
		if(appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			msg = "Cancellation Succeded";
		}
		
		return new ApiResponse(msg);
	}

}
