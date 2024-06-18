package com.reservation.controller;

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

import com.reservation.dto.ReservationDto;
import com.reservation.entites.Reservation;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	/*
	 * Create Reservation: • Endpoint: POST /reservations • Request:JSON payload
	 * containing reservation details (guest name, check-in date, check-out date,
	 * room ID). • Response: Confirmation of the created reservation.
	 */
	
	@PostMapping("/create")
	public ResponseEntity<?> createReservation(@RequestBody ReservationDto reservation){
	
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createNewReservation(reservation));
		
	}
	/*
	 * Get Available rooms: • Endpoint: GET /rooms?available=yes • Request: Get all
	 * available rooms. • Response: Return the details of available rooms in JSON
	 * format.
	 */
	
	@GetMapping("/availableRooms")
	public ResponseEntity<?> getAvailableRooms(){
		System.out.println("in get");
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.getAvailableRooms());
		
	}
	
	/*
	 * Cancel Reservation: • Endpoint: DELETE /reservations/{reservationId} •
	 * RequestCancel a reservation by providing its unique identifier. • Response:
	 * Confirmation of the canceled reservation.
	 */
	
	@DeleteMapping("/cancel")
	public ResponseEntity<?> cancelReservation(@RequestParam Long roomId){
		 return ResponseEntity.status(HttpStatus.OK).body(reservationService.cancelReservation(roomId));
	}
}
