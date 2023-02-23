package com.automobile.services;

import java.util.List;

import com.automobile.dao.BillDAO;
import com.automobile.dao.BillDAOImpl;
import com.automobile.dao.ReservationDAOImpl;
import com.automobile.entity.Bill;
import com.automobile.entity.Reservation;

public class BillServiceImpl implements BillService {

	@Override
	public List<Bill> findAll() {

		BillDAOImpl billDAOImpl = new BillDAOImpl();
		List<Bill> BillList = billDAOImpl.findAll();
		return BillList;

	}

	@Override
	public void save(Bill bill) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.save(bill);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(Bill bill) {

		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.update(bill);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public void delete(Bill bill) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.delete(bill);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	}

	@Override
	public Bill findById(int billId) {

		BillDAOImpl billDAOImpl = new BillDAOImpl();
		Bill bill = billDAOImpl.findById(billId);
		return bill;

	}

	@Override
	public Bill generateBillById(int billId) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		Bill bill = billDAOImpl.generateBillById(billId);
		return null;
	}
}
