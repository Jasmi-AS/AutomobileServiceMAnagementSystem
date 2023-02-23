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
import com.automobile.entity.Reservation;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public List<Reservation> findAll() {

		List<Reservation> reservationList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from reservation";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int reservId = resultSet.getInt(1);
				int vehicleId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				String reservDate = resultSet.getString(4);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehicleId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);

				Reservation reservation = new Reservation(reservId, vehicle, staff, reservDate);
				reservationList.add(reservation);

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

		return reservationList;

	}

	@Override
	public int save(Reservation reservation) {

		final String insertSQL = "insert into reservation(vehicle_id,staff_id,reservation_date)" + " values(?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, reservation.getVehicle().getVehicleId());
			preparedStatement.setInt(2, reservation.getStaff().getStaffId());
			preparedStatement.setString(3, reservation.getReservationDate());

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
	public int update(Reservation reservation) {

		String insertSQL = "update  reservation set vehicle_id=?,staff_id=?,reservation_date=? where reservation_id=?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, reservation.getVehicle().getVehicleId());
			preparedStatement.setInt(2, reservation.getStaff().getStaffId());
			preparedStatement.setString(3, reservation.getReservationDate());
			preparedStatement.setInt(4, reservation.getReservationId());
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
	public int delete(Reservation reservation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from reservation where reservation_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, reservation.getReservationId());
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
	public Reservation findById(int reservationId) {
		Reservation reservation = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from reservation where reservation_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, reservationId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int reservationiId = resultSet.getInt(1);
				int vehcileId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				String reservationDate = resultSet.getString(4);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehcileId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
				reservation = new Reservation(reservationiId, vehicle, staff, reservationDate);

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
		return reservation;

	}

}
