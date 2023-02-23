package com.automobile.services;

import java.util.List;

import com.automobile.dao.BillDAOImpl;
import com.automobile.dao.ReservationDAOImpl;
import com.automobile.entity.Bill;
import com.automobile.entity.Reservation;

public class ReservationServiceImpl implements ReservationService {

	@Override
	public List<Reservation> findAll() {

		ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
		List<Reservation> reservationList = reservationDAOImpl.findAll();
		return reservationList;
	}

	@Override
	public void save(Reservation Reservation) {

		ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
		int row = reservationDAOImpl.save(Reservation);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Reservation Reservation) {

		ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
		int row = reservationDAOImpl.update(Reservation);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public void delete(Reservation Reservation) {

		ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
		int row = reservationDAOImpl.delete(Reservation);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	}

	@Override
	public Reservation findById(int reservationId) {
		ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl();
		Reservation reservation = reservationDAOImpl.findById(reservationId);		
		return reservation;

		
	}

}
