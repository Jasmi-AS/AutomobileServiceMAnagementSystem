package com.automobile.services;

import java.util.List;

import com.automobile.dao.SparePartsDAOImpl;
import com.automobile.dao.StaffDAO;
import com.automobile.dao.StaffDAOImpl;
import com.automobile.dao.VehicleDAOImpl;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class StaffServiceImpl implements StaffService {

	@Override
	public List<Staff> findAll() {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		List<Staff> staffList = staffDAOImpl.findAll();
		return staffList;
	}

	@Override
	public void save(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.save(staff);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.update(staff);
		if (row !=0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

		return 0;
	}

	@Override
	public void delete(Staff staff) {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.delete(staff);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

		
	}

	@Override
	public Staff findById(int StaffId) {

		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		Staff staff = staffDAOImpl.findById(StaffId);
		return staff;

	}

}
