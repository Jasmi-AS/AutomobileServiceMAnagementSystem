package com.automobile.services;

import java.util.List;

import com.automobile.entity.Reservation;

public interface ReservationService {
	List<Reservation> findAll();

	void save(Reservation Reservation);

	int update(Reservation Reservation);

	void delete(Reservation Reservation);

	Reservation findById(int reservationId);

}
