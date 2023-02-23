package com.automobile.services;

import java.util.List;

import com.automobile.entity.Vehicle;

public interface VehicleService {
	List<Vehicle> findAll();

	void save(Vehicle vehicle);

	int update(Vehicle vehicle);

	void delete(Vehicle vehicle);

	Vehicle findById(int vehicleId);

}
