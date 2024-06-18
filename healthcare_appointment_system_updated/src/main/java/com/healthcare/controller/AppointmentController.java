package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entities.Appointment;
import com.healthcare.entities.Patients;
import com.healthcare.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/create")
	ResponseEntity<?> createNewAppointment(@RequestBody Appointment appointment,@RequestParam Long patient_id) {
		System.out.println("in create");
		//System.out.println(appointmentService.createAppointment(appointment));
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(appointment,patient_id));
	}
	
	@GetMapping("/view")
	ResponseEntity<?> viewAllApointments(Long patient_id){
		System.out.println("in view");
		return ResponseEntity.status(HttpStatus.OK).body(appointmentService.viewAppointments(patient_id));
	}
	
	@DeleteMapping("/cancel/{id}")
	ResponseEntity<?> cancelAppointment(@RequestParam Long id){
		System.out.println("in cancel");
		return ResponseEntity.status(HttpStatus.OK).body(appointmentService.cancelAppointment(id));
		
	}
}
