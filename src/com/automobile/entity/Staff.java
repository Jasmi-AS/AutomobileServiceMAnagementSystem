package com.automobile.entity;

public class Staff {
	private int staffId;
	private String staffName;
	private String staffPhoneNumber;

	public Staff(int staffId, String staffName, String staffPhoneNumber) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public Staff() {
		super();
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

}
