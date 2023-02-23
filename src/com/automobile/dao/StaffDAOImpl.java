package com.automobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.automobile.dbconnectionpool.DBConnectionPool;
import com.automobile.entity.Bill;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class StaffDAOImpl implements StaffDAO {

	@Override
	public List<Staff> findAll() {
		List<Staff> staffList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from staff";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int staffId = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String staffPhoneNumnber = resultSet.getString(3);
				Staff staff = new Staff(staffId, staffName, staffPhoneNumnber);
				staffList.add(staff);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return staffList;
	}

	@Override
	public int save(Staff staff) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final String INSERT_SQL = "insert into staff(staff_id,staff_name,staff_phonenumber) values(?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, staff.getStaffId());
			preparedStatement.setString(2, staff.getStaffName());
			preparedStatement.setString(3, staff.getStaffPhoneNumber());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int update(Staff staff) {

		String insertSQL = "update  staff set staff_name=?,staff_phonenumber=? where staff_Id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, staff.getStaffName());
			preparedStatement.setString(2, staff.getStaffPhoneNumber());
			preparedStatement.setInt(3, staff.getStaffId());

			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int delete(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from staff where staff_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, staff.getStaffId());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Staff findById(int staffId) {
		Staff staff = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from staff where staff_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, staffId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int staffid = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String staffPhoneNumber = resultSet.getString(3);

				staff = new Staff(staffId, staffName, staffPhoneNumber);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return staff;

	}

}
