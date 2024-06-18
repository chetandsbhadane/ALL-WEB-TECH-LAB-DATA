package com.healthcare.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Appointment {

	@Id
	@GeneratedValue
	private Long id;
	private String patientName;
	
	@Enumerated(EnumType.STRING)
	private Doctors doctorName;
	private LocalDate date;
	private LocalTime time;

	public Appointment(String patientName, Doctors doctorName, LocalDate date  , LocalTime time ) {
		super();
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.time = time;
	}
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable=false)
	private Patients patient;

}
