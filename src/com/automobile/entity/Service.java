package com.automobile.entity;

public class Service {
	private int serviceId;
	private Vehicle vehicle;
	private Staff staff;
	private String serviceType;
	private Double serviceAmount;

	public Service() {
		super();
	}

	public Service(int serviceId, Vehicle vehicle, Staff staff, String serviceType, Double serviceAmount) {
		super();
		this.serviceId = serviceId;
		this.vehicle = vehicle;
		this.staff = staff;
		this.serviceType = serviceType;
		this.serviceAmount = serviceAmount;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Double getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(Double serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

}
