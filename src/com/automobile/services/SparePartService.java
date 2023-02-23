package com.automobile.services;

import java.util.List;

import com.automobile.entity.SpareParts;

public interface SparePartService {
	List<SpareParts> findAll();

	void save(SpareParts spareParts);

	int update(SpareParts spareParts);

	void delete(SpareParts spareParts);

	SpareParts findById(int sparePartsId);

}
