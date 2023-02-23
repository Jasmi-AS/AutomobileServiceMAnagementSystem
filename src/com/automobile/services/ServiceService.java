package com.automobile.services;

import java.util.List;

import com.automobile.entity.Service;

public interface ServiceService {
	List<Service> findAll();

	void save(Service service);

	int update(Service service);

	void delete(Service service);

	Service findById(int serviceId);

}
