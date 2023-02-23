package com.automobile.services;

import java.util.List;

import com.automobile.dao.BillDAOImpl;
import com.automobile.dao.CustomerDAOImpl;
import com.automobile.dao.SparePartsDAOImpl;
import com.automobile.entity.Bill;
import com.automobile.entity.Customer;
import com.automobile.entity.SpareParts;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> findAll() {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		List<Customer> customerList = customerDAOImpl.findAll();
		return customerList;
	}

	@Override
	public void save(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.save(customer);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Customer customer) {

		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.update(customer);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public void delete(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.delete(customer);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	}

	@Override
	public Customer findById(int customerId) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		Customer customer = customerDAOImpl.findById(customerId);	
		return customer;
		
	}

}
