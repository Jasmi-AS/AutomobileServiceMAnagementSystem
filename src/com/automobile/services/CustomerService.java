package com.automobile.services;

import java.util.List;

import com.automobile.entity.Bill;
import com.automobile.entity.Customer;
import com.automobile.entity.SpareParts;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer customer);

	int update(Customer customer);

	void delete(Customer customer);
	
	Customer findById(int customerId);

}
