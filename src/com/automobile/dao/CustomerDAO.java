package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Customer;

public interface CustomerDAO {
	List<Customer> findAll();

	int save(Customer customer);

	int update(Customer customer);

	int delete(Customer customer);

	Customer findById(int customerId);

}
