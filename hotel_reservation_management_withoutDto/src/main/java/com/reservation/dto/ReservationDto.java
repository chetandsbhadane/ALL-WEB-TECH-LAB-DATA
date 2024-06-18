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

	private String guestName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private Long roomId;
	
}
