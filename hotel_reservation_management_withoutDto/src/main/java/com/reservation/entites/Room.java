package com.reservation.entites;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservation.repository.RoomRepository;

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
	private Integer price;
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	@Transient
	@Autowired
	private RoomRepository roomRepository; 
	
	public Room(Long roomId,int roomNumber, RoomType roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		
		//this.price = RoomType.valueOf(roomType).getValue();
		this.price = (Integer) roomType.getValue();
		this.availability = getAvailabilityById(roomId);
	}
	
	public Availability getAvailabilityById(Long roomId) {
		System.out.println("availibilty->"+roomRepository.findById(roomId).orElseThrow().getAvailability());
		return roomRepository.findById(room_id).orElseThrow().getAvailability();
	}
	
	public int getPriceById(Long roomId) {
System.out.println("price->"+roomRepository.findById(roomId).orElseThrow().getPrice());
		return roomRepository.findById(roomId).orElseThrow().getPrice();
		
	}
}
