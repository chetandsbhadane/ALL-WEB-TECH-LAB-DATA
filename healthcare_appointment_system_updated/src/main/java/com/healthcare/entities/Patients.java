package com.healthcare.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patient_id;
	private String patientName;
	
	public Patients(String patientName) {
		super();
		this.patientName = patientName;
	} 
	
//	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Appointment> appointmentList = new ArrayList<>();
//	
//	public void addAppointment(Appointment appointment) {
//		appointmentList.add(appointment);
//		appointment.setPatient(this);
//	}
//	
//	public void removeAppointment(Appointment appointment) {
//		appointmentList.remove(appointment);
//		appointment.setPatient(null);
//	}
}
