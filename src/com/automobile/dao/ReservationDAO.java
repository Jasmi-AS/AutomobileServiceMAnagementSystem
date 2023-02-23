package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Bill;
import com.automobile.entity.Reservation;

public interface ReservationDAO {
	List<Reservation> findAll();

	int save(Reservation reservation);

	int update(Reservation reservation);

	int delete(Reservation reservation);

	Reservation findById(int reservationId);

}
