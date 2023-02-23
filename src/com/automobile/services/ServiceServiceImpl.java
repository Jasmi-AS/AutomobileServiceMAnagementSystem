package com.automobile.services;

import java.util.List;

import com.automobile.dao.ReservationDAOImpl;
import com.automobile.dao.ServiceDAO;
import com.automobile.dao.ServiceDAOImpl;
import com.automobile.dao.SparePartsDAOImpl;
import com.automobile.entity.Reservation;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;

public class ServiceServiceImpl implements ServiceService {

	@Override
	public List<Service> findAll() {

		ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
		List<Service> serviceList = serviceDAOImpl.findAll();
		return serviceList;

	}

	@Override
	public void save(Service service) {

		ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
		int row = serviceDAOImpl.save(service);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Service service) {
		ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
		int row = serviceDAOImpl.update(service);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public void delete(Service service) {
		ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
		int row = serviceDAOImpl.delete(service);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	}

	@Override
	public Service findById(int serviceId) {
		ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
		Service service = serviceDAOImpl.findById(serviceId);
		return service;

	}

}
