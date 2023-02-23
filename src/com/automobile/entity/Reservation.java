package com.automobile.entity;

public class Reservation {
	private int reservationId;
	private Vehicle vehicle;
	private Staff staff;
	private String reservationDate;

	public Reservation() {
		super();
	}

	public Reservation(int reservationId, Vehicle vehicle, Staff staff, String reservationDate) {
		super();
		this.reservationId = reservationId;
		this.vehicle = vehicle;
		this.staff = staff;
		this.reservationDate = reservationDate;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

}
