package com.automobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.automobile.dbconnectionpool.DBConnectionPool;
import com.automobile.entity.Customer;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class VehicleDAOImpl implements VehicleDAO {

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> vehicleList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from vehicle";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int vehicleId = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				String vehicleName = resultSet.getString(3);
				String vehicleType = resultSet.getString(4);
				String vehicleNumber = resultSet.getString(5);

				Customer customer = new Customer();
				customer.setCusId(customerId);
				Vehicle vehicle = new Vehicle(vehicleId, customer, vehicleName, vehicleType, vehicleNumber);
				vehicleList.add(vehicle);

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

		return vehicleList;
	}

	@Override
	public int save(Vehicle vehicle) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into vehicle(vehicle_id,customer_id,vehicle_name,vehicle_type,vehicle_number) values(?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, vehicle.getVehicleId());
			preparedStatement.setInt(2, vehicle.getCustomer().getCusId());
			preparedStatement.setString(3, vehicle.getVehicleName());
			preparedStatement.setString(4, vehicle.getVehicleType());
			preparedStatement.setString(5, vehicle.getVehicleNumber());
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
	public int update(Vehicle vehicle) {
		String insertSQL = "update  vehicle set customer_id=?,vehicle_name=?,vehicle_type=?,vehicle_number=? where vehicle_Id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, vehicle.getCustomer().getCusId());
			preparedStatement.setString(2, vehicle.getVehicleName());
			preparedStatement.setString(3, vehicle.getVehicleType());
			preparedStatement.setString(4, vehicle.getVehicleNumber());
			preparedStatement.setInt(5, vehicle.getVehicleId());

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
	public int delete(Vehicle vehicle) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from vehicle where vehicle_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, vehicle.getVehicleId());
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
	public Vehicle findById(int vehicleId) {
		Vehicle vehicle = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from vehicle where vehicle_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, vehicleId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int vehicleid = resultSet.getInt(1);
				int customerId = resultSet.getInt(2);
				String vehicleName = resultSet.getString(3);
				String vehicleType = resultSet.getString(4);
				String vehicleNumber = resultSet.getString(5);

				Customer customer = new Customer();
				customer.setCusId(customerId);

				vehicle = new Vehicle(vehicleId, customer, vehicleName, vehicleType, vehicleNumber);

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
		return vehicle;

	}

}
