package com.reservation.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.reservation.entites.Room;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationDto {

	//@JsonProperty(access = Access.READ_ONLY)
	private Long reservationId;
	//@JsonProperty(access = Access.READ_ONLY)
	private String guestName;
	//@JsonProperty(access = Access.READ_ONLY)
	private LocalDate checkInDate;
	//@JsonProperty(access = Access.READ_ONLY)
	private LocalDate checkOutDate;
	
	private Room room;
	
}
