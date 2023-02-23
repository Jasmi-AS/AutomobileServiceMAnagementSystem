package com.automobile.dao;

import java.util.List;

import com.automobile.entity.Staff;

public interface StaffDAO {
	List<Staff> findAll();

	int save(Staff staff);

	int update(Staff staff);

	int delete(Staff staff);

	Staff findById(int staffId);

}
