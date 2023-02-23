package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Service;

public interface ServiceDAO {
	List<Service> findAll();

	int save(Service service);

	int update(Service service);

	int delete(Service service);

	Service findById(int serviceId);

}
