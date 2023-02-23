package com.automobile.services;

import java.util.List;

import com.automobile.dao.StaffDAOImpl;
import com.automobile.dao.VehicleDAOImpl;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class VehicleServiceImpl implements VehicleService {

	@Override
	public List<Vehicle> findAll() {
		VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl();
		List<Vehicle> vehicletList = vehicleDAOImpl.findAll();
		return vehicletList;

	}

	@Override
	public void save(Vehicle vehicle) {
		VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl();
		int row = vehicleDAOImpl.save(vehicle);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Vehicle vehicle) {
		VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl();
		int row = vehicleDAOImpl.update(vehicle);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");

		return 0;
	}

	@Override
	public void delete(Vehicle vehicle) {
		VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl();
		int row = vehicleDAOImpl.delete(vehicle);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	}

	@Override
	public Vehicle findById(int vehicleId) {
		VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl();
		Vehicle vehicle = vehicleDAOImpl.findById(vehicleId);
		return vehicle;

	}

}
