package com.reservation.service;

import java.util.List;

import com.reservation.dto.ApiResponse;
import com.reservation.dto.ReservationDto;
import com.reservation.entites.Reservation;
import com.reservation.entites.Room;

public interface ReservationService {

	ApiResponse createNewReservation(ReservationDto reservationDto);

	List<Room> getAvailableRooms();

	ApiResponse cancelReservation(Long roomId);

}
