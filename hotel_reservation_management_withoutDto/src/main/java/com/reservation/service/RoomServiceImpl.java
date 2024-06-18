package com.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository;
	
}
