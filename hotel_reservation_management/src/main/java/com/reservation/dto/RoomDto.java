package com.reservation.dto;

import com.reservation.entites.RoomType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {

	private int roomNumber;
	private RoomType roomType;
	
}
