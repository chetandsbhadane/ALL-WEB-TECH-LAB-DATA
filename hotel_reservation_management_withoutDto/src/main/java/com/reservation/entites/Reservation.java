package com.reservation.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;

import com.reservation.repository.RoomRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Reservation:Reservation ID, guest name, check-in date, check-out date, room ID, total price.

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Reservation {

//	@Autowired
//	@Transient
//	private RoomRepository roomRepository;
//	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reservationId;
	
	private String guestName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private Integer price;
	
	@OneToOne
	@JoinColumn(name = "roomId",nullable = false)
	private Room room;

	public Reservation(String guestName, LocalDate checkInDate, LocalDate checkOutDate,Long roomId) {
		super();
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room.setRoom_id(roomId);
		//this.price = getPriceById(roomId);
		
	}
	
//	public int getPriceById(Long roomId) {
//		return roomRepository.findById(roomId).orElseThrow().getPrice();
//	}
	
	
	
	
}
