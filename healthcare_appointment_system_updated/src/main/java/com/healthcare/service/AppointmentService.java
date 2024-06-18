package com.healthcare.service;

import java.util.Optional;

import com.healthcare.dto.ApiResponse;
import com.healthcare.entities.Appointment;

public interface AppointmentService {

	Appointment createAppointment(Appointment newAppointment, Long patient_id);

	Optional<Appointment> viewAppointments(Long patient_id);

	ApiResponse cancelAppointment(Long id);
	
}
