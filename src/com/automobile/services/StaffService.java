package com.automobile.services;

import java.util.List;

import com.automobile.entity.Staff;

public interface StaffService {
	List<Staff> findAll();

	void save(Staff staff);

	int update(Staff staff);

	void delete(Staff staff);

	Staff findById(int StaffId);

}
