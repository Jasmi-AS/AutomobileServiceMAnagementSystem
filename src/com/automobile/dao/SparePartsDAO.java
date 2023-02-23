package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Bill;
import com.automobile.entity.SpareParts;

public interface SparePartsDAO {

	List<SpareParts> findAll();

	int save(SpareParts spareParts);

	int update(SpareParts spareParts);

	int delete(SpareParts spareParts);

	SpareParts findById(int sparePartsId);

}
