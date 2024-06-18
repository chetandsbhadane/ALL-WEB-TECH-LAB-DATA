package com.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.reservation.dto.ApiResponse;
import com.reservation.dto.ReservationDto;
import com.reservation.entites.Availability;
import com.reservation.entites.Reservation;
import com.reservation.entites.Room;
import com.reservation.repository.ReservationRepository;
import com.reservation.repository.RoomRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse createNewReservation(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		String msg ="Room not reserved";
		
		Reservation reservation = mapper.map(reservationDto, Reservation.class);
		reservation.setRoom(roomRepository.findById(reservationDto.getRoomId()).orElseThrow());
		System.out.println(reservation.getRoom().getPrice());
		
		if(roomRepository.findById(reservation.getRoom().getRoom_id()).orElseThrow().getAvailability() != Availability.NO) {
			roomRepository.findById(reservation.getRoom().getRoom_id()).orElseThrow().setAvailability(Availability.NO);
			System.out.println("before setting price");
			
			reservation.setPrice(reservation.getRoom().getPrice());
			System.out.println("after setting price");
			//reservation.getRoom().setAvailability(Availability.NO);	
			reservationRepository.save(reservation);
			msg ="Room reservation successful";
		}
		
		return new ApiResponse(msg);
	}

	@Override
	public List<Room> getAvailableRooms() {
		// TODO Auto-generated method stub
		System.out.println("in get service");
		List<Room> roomList = roomRepository.findAll();
		System.out.println(roomList);
		List<Room> availableRooms = new ArrayList<Room>();
		for(Room room : roomList) {
			if(room.getAvailability()==Availability.YES) {
				availableRooms.add(room);
			}	
		}
		System.out.println(availableRooms);
		return availableRooms;
	}

	@Override
	public ApiResponse cancelReservation(Long roomId) {
		// TODO Auto-generated method stub
		String msg="Reservation Cancel Failed";
		if(reservationRepository.existsById(roomId)) {
			reservationRepository.deleteById(roomId);
			msg="Reservation Cancelled";
		}
		return new ApiResponse(msg);
	} 
	
}
