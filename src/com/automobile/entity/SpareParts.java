package com.automobile.entity;

public class SpareParts {
	private int sparepartsId;
	private String sparepartsName;
	private double sparepartsAmount;

	public SpareParts() {
		super();
	}

	public SpareParts(int sparepartsId,  String sparepartsName,
			double sparepartsAmount) {
		super();
		this.sparepartsId = sparepartsId;
				this.sparepartsName = sparepartsName;
		this.sparepartsAmount = sparepartsAmount;
	}

	public int getSparepartsId() {
		return sparepartsId;
	}

	public void setSparepartsId(int sparepartsId) {
		this.sparepartsId = sparepartsId;
	}

	

	public String getSparepartsName() {
		return sparepartsName;
	}

	public void setSparepartsName(String sparepartsName) {
		this.sparepartsName = sparepartsName;
	}

	public double getSparepartsAmount() {
		return sparepartsAmount;
	}

	public void setSparepartsAmount(double sparepartsAmount) {
		this.sparepartsAmount = sparepartsAmount;
	}

}
