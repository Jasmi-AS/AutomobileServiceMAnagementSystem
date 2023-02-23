package com.automobile.services;

import java.util.List;

import com.automobile.entity.Bill;

public interface BillService {
	List<Bill> findAll();

	void save(Bill bill);

	int update(Bill bill);

	void delete(Bill bill);
	
	Bill findById(int billId);
	
	Bill generateBillById(int billId);
			

}
