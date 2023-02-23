package com.automobile.entity;

public class Bill {
	private int billId;
	private Vehicle vehicle;
	private Service service;
	private Customer customer;
	private String paymentMode;
	private double billAmount;
	private String billDate;

	public Bill() {
		super();
	}

	public Bill(int billId, Vehicle vehicle, Service service, Customer customer, String paymentMode, double billAmount,
			String billDate) {
		super();
		this.billId = billId;
		this.vehicle = vehicle;
		this.service = service;
		this.customer = customer;
		this.paymentMode = paymentMode;
		this.billAmount = billAmount;
		this.billDate = billDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	
}