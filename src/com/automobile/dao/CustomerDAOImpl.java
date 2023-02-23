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
import com.automobile.entity.Customer;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Vehicle;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from customer";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int cusId = resultSet.getInt(1);
				String cusName = resultSet.getString(2);
				String cusAddress = resultSet.getString(3);
				String cusPhoneNumber = resultSet.getString(4);
				Customer customer = new Customer(cusId, cusName, cusAddress, cusPhoneNumber);
				customerList.add(customer);

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

		return customerList;

	}

	@Override
	public int save(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into customer(customer_name,customer_address,customer_phonenumber) values(?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, customer.getCusName());
			preparedStatement.setString(2, customer.getCusAddress());
			preparedStatement.setString(3, customer.getCusPhoneNumber());
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
	public int update(Customer customer) {

		String insertSQL = "update  customer set customer_name=?,customer_address=?,customer_phonenumber=? where customer_Id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, customer.getCusName());
			preparedStatement.setString(2, customer.getCusAddress());
			preparedStatement.setString(3, customer.getCusPhoneNumber());
			preparedStatement.setInt(4, customer.getCusId());

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

	public int delete(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from customer where customer_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, customer.getCusId());
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
	public Customer findById(int customerId) {

		Customer customer = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from customer where customer_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, customerId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int customerid=resultSet.getInt(1);
				String customerName = resultSet.getString(2);
				String customerAddress = resultSet.getString(3);
				String customerPhoneNumber = resultSet.getString(4);

				customer = new Customer(customerid,customerName,customerAddress,customerPhoneNumber);

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
		return customer;

	}
}
