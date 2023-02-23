package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Vehicle;

public interface VehicleDAO {
	List<Vehicle> findAll();

	int save(Vehicle vehicle);

	int update(Vehicle vehicle);

	int delete(Vehicle vehicle);

	Vehicle findById(int vehicleId);

}
