package com.reservation.entites;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Room:Room ID, room number, type (single, double, suite), price, availability.

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long room_id;
	
	private int roomNumber;
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	private int price;
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	public Room(int roomNumber, RoomType roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = roomType.getValue();
		this.availability = Availability.YES;
	}
	
	
	
}
