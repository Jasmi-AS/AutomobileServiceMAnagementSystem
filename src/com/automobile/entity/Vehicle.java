package com.automobile.entity;

public class Vehicle {

	private int vehicleId;
	private Customer customer;
	private String vehicleName;
	private String vehicleType;
	private String vehicleNumber;

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, Customer customer, String vehicleName, String vehicleType, String vehicleNumber) {
		super();
		this.vehicleId = vehicleId;
		this.customer = customer;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

}
