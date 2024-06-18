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
	
	private ModelMapper mapper;
	
	
	@Override
	public ReservationDto createNewReservation(ReservationDto reservation) {
		// TODO Auto-generated method stub
		//String msg ="Room not reserved";
		System.out.println("reservation -->"+reservation);
		Reservation reservationEntity = mapper.map(reservation,Reservation.class);
		
		if(reservationRepository.save(reservationEntity) != null && roomRepository.findById(reservationEntity.getRoom().getRoom_id()).orElseThrow().getAvailability() != Availability.NO) {
			roomRepository.findById(reservationEntity.getRoom().getRoom_id()).orElseThrow().setAvailability(Availability.NO);
			//reservation.getRoom().setAvailability(Availability.NO);	
			//msg ="Room reservation successful";
		}
		
		return mapper.map(reservationEntity, ReservationDto.class);
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
