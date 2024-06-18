package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
