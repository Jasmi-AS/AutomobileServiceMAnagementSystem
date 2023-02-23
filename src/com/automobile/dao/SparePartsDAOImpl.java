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

public class SparePartsDAOImpl implements SparePartsDAO {

	@Override
	public List<SpareParts> findAll() {

		List<SpareParts> sparePartsList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from spareParts";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int SparePartsId = resultSet.getInt(1);
				String sparePartsName = resultSet.getString(2);
				double sparePartsAmount = resultSet.getDouble(3);
				SpareParts spareParts = new SpareParts(SparePartsId, sparePartsName,sparePartsAmount);
				sparePartsList.add(spareParts);

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

		return sparePartsList;
	}

	@Override
	public int save(SpareParts spareParts) {
		final String insertSQL = "insert into spareParts(spareparts_name,spareparts_amount)"
				+ " values(?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, spareParts.getSparepartsName());
			preparedStatement.setDouble(2, spareParts.getSparepartsAmount());
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
	public int update(SpareParts spareParts) {

		String insertSQL = "update  spareParts set spareparts_Name=?,spareparts_amount=? where spareparts_Id= ? ";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, spareParts.getSparepartsName());
			preparedStatement.setDouble(2, spareParts.getSparepartsAmount());
			preparedStatement.setDouble(3, spareParts.getSparepartsId());
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
	public int delete(SpareParts spareParts) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "delete from spareParts where spareparts_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, spareParts.getSparepartsId());
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
	public SpareParts findById(int sparePartsId) {
		SpareParts spareParts = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from spareParts where spareParts_id=?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setInt(1, sparePartsId);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int sparePartsid = resultSet.getInt(1);
				String serviceType = resultSet.getString(2);
				double serviceAmount = resultSet.getDouble(3);

				spareParts = new SpareParts(sparePartsId, serviceType, serviceAmount);

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
		return spareParts;

	}

}
