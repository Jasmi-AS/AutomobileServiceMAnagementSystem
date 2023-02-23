package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Bill;

public interface BillDAO {
	List<Bill> findAll();

	int save(Bill bill);

	int update(Bill bill);

	int delete(Bill bill);

	Bill findById(int billId);
	
    Bill generateBillById(int billId) ;
    

}
