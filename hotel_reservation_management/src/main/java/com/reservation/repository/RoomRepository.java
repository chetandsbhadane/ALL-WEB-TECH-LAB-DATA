package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entites.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
