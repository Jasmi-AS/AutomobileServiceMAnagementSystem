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
import com.automobile.entity.Reservation;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class ServiceDAOImpl implements ServiceDAO {

	@Override
	public List<Service> findAll() {

		List<Service> serviceList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from service";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int serviceId = resultSet.getInt(1);
				int vehicleId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				String serviceType = resultSet.getString(4);
				double serviceAmount = resultSet.getDouble(5);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehicleId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
//				Service service = new Service();

				Service service = new Service(serviceId,vehicle,staff,serviceType,serviceAmount);
				serviceList.add(service);

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

		return serviceList;
	}

	@Override
	public int save(Service service) {
		final String insertSQL = "insert into service(vehicle_id,staff_id,service_type,service_amount)"
				+ " values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, service.getVehicle().getVehicleId());
			preparedStatement.setInt(2, service.getStaff().getStaffId());
			preparedStatement.setString(3, service.getServiceType());
			preparedStatement.setDouble(4, service.getServiceAmount());

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
	public int update(Service service) {

		String insertSQL = "update  service set vehicle_id=?,staff_id=?,service_type=?,service_amount=? where service_id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, service.getVehicle().getVehicleId());
			preparedStatement.setInt(2, service.getStaff().getStaffId());
			preparedStatement.setString(3, service.getServiceType());
			preparedStatement.setDouble(4, service.getServiceAmount());
			preparedStatement.setInt(5, service.getServiceId());

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
	public int delete(Service service) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from service where service_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, service.getServiceId());
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
	public Service findById(int serviceId) {
		Service service = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from service where service_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, serviceId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int serviceid = resultSet.getInt(1);
				int vehicleId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				String serviceType=resultSet.getString(4);
				double serviceAmount=resultSet.getDouble(5);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehicleId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
				service = new Service(serviceId, vehicle, staff, serviceType,serviceAmount);

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
		return service;	
	}
}
	


