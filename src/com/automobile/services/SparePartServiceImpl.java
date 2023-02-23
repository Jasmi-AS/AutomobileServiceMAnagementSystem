package com.automobile.services;

import java.util.List;
import java.util.Scanner;

import com.automobile.dao.ServiceDAOImpl;
import com.automobile.dao.SparePartsDAOImpl;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;

public class SparePartServiceImpl implements SparePartService {

	@Override
	public List<SpareParts> findAll() {
		SparePartsDAOImpl sparePartsDAOImpl = new SparePartsDAOImpl();
		List<SpareParts> sparePartsList = sparePartsDAOImpl.findAll();
		return sparePartsList;
	}

	@Override
	public void save(SpareParts spareParts) {

		SparePartsDAOImpl sparePartsDAOImpl = new SparePartsDAOImpl();
		int row = sparePartsDAOImpl.save(spareParts);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public int update(SpareParts spareParts) {
		SparePartsDAOImpl sparePartsDAOImpl = new SparePartsDAOImpl();
		int row = sparePartsDAOImpl.update(spareParts);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public void delete(SpareParts spareParts) {
		SparePartsDAOImpl sparePartsDAOImpl = new SparePartsDAOImpl();
		int row = sparePartsDAOImpl.delete(spareParts);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");

	
	}

	@Override
	public SpareParts findById(int sparePartsId) {

		SparePartsDAOImpl sparePartsDAOImpl = new SparePartsDAOImpl();
		SpareParts spareParts = sparePartsDAOImpl.findById(sparePartsId);
		return spareParts;

	}
	
	}


