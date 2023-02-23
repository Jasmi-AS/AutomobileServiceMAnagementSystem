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
import com.automobile.entity.Vehicle;

public class BillDAOImpl implements BillDAO {

	@Override
	public List<Bill> findAll() {
		List<Bill> billList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int billId = resultSet.getInt(1);
				int vehicleId = resultSet.getInt(2);
				int serviceId = resultSet.getInt(3);
				int customerId = resultSet.getInt(4);
				String paymentMode = resultSet.getString(5);
				double billAmount = resultSet.getDouble(6);
				String billDate = resultSet.getString(7);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehicleId);
				Service service = new Service();
				service.setServiceId(serviceId);
				Customer customer = new Customer();
				customer.setCusId(customerId);

				Bill bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);
				billList.add(bill);

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

		return billList;

	}

	@Override
	public int save(Bill bill) {

		final String insertSQL = "insert into bill(vehicle_id,service_id,customer_id,payment_mode,bill_amount,bill_date)"
				+ " values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bill.getVehicle().getVehicleId());
			preparedStatement.setInt(2, bill.getService().getServiceId());
			preparedStatement.setInt(3, bill.getCustomer().getCusId());
			preparedStatement.setString(4, bill.getPaymentMode());
			preparedStatement.setDouble(5, bill.getBillAmount());
			preparedStatement.setString(6, bill.getBillDate());

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
	public int update(Bill bill) {

		String insertSQL = "update  bill set vehicle_id=?,service_id=?,customer_id=?,payment_mode=?,bill_amount=?,bill_date=? where bill_id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bill.getVehicle().getVehicleId());
			preparedStatement.setInt(2, bill.getService().getServiceId());
			preparedStatement.setInt(3, bill.getCustomer().getCusId());
			preparedStatement.setString(4, bill.getPaymentMode());
			preparedStatement.setDouble(5, bill.getBillAmount());
			preparedStatement.setString(6, bill.getBillDate());
			preparedStatement.setInt(7, bill.getBillId());

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
	public int delete(Bill bill) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from bill where bill_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, bill.getBillId());
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
	public Bill findById(int billId) {
		Bill bill = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from bill where bill_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, billId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int billid = resultSet.getInt(1);
				int vehcileId = resultSet.getInt(2);
				int serviceId = resultSet.getInt(3);
				int customerId = resultSet.getInt(4);
				String paymentMode = resultSet.getString(5);
				double billAmount = resultSet.getDouble(6);
				String billDate = resultSet.getString(7);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehcileId);
				Service service = new Service();
				service.setServiceId(serviceId);
				Customer customer = new Customer();
				customer.setCusId(customerId);

				bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);

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
		return bill;

	}

	public Bill generateBillById(int billId) {
		Bill bill = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill where bill_id=" + billId;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int bill_id = resultSet.getInt(1);
				int vehicleId = resultSet.getInt(2);
				int serviceId = resultSet.getInt(3);
				int customerId = resultSet.getInt(4);
				String paymentMode = resultSet.getString(5);
				double billAmount = resultSet.getDouble(6);
				String billDate = resultSet.getString(7);

				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(vehicleId);

				Service service = new Service();
				service.setServiceId(serviceId);

				Customer customer = new Customer();
				customer.setCusId(customerId);

//				bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);

				String selectSQL2 = "Select service_type ,service_id from service where service_id=" + serviceId;

				try {
					DataSource ds2 = DBConnectionPool.getDataSource();
					connection = ds2.getConnection();
					prepStmt = connection.prepareStatement(selectSQL2);
					ResultSet resultSet2 = prepStmt.executeQuery();
					while (resultSet2.next()) {
						String serviceType = resultSet2.getString(1);
						int vehicleid = resultSet2.getInt(2);

						String selectSQL3 = "Select vehicle_id, vehicle_name,vehicle_number from vehicle  where vehicle_id="
								+ vehicleId;

						try {
							DataSource ds3 = DBConnectionPool.getDataSource();
							connection = ds3.getConnection();
							prepStmt = connection.prepareStatement(selectSQL3);
							ResultSet resultSet3 = prepStmt.executeQuery();
							while (resultSet3.next()) {
								int customerid = resultSet3.getInt(1);
								String vehicleName = resultSet3.getString(2);
								String vehicleNumber = resultSet3.getString(3);
								

								String selectSQL4 = "Select customer_name,customer_phonenumber from customer  where customer_id="
										+ customerId;

								try {
									DataSource ds4 = DBConnectionPool.getDataSource();
									connection = ds4.getConnection();
									prepStmt = connection.prepareStatement(selectSQL3);
									ResultSet resultSet4 = prepStmt.executeQuery();
									while (resultSet4.next()) {
										String customerName = resultSet3.getString(1);
										String customerphoneNumber = resultSet3.getString(2);

									}
								} catch (SQLException e) {
									e.printStackTrace();

								}

							}
						} catch (SQLException e) {
							e.printStackTrace();

						}
					}
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
				bill = new Bill(billId, vehicle, service, customer, paymentMode, billAmount, billDate);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return bill;
	}

}
