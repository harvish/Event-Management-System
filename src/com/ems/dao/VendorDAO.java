package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ems.constants.QueryConstants;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorTO;
import com.ems.util.DBUtil;

public class VendorDAO {
Connection connection=null;
PreparedStatement preparedSatement=null;
private static final Logger LOG = Logger.getLogger("Vendor DAO");
	public int getVendorID() throws DatabaseExceptions {
		// TODO Auto-generated method stub
		LOG.info("getting vendor id");
		int vendorId=0;
		try {
			connection=DBUtil.getConnection();
			preparedSatement=connection.prepareStatement(QueryConstants.GET_VENDOR_ID);
			ResultSet resultSet=preparedSatement.executeQuery();
			while(resultSet.next())
			{
				vendorId=resultSet.getInt(1);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("class not found exception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("database exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("IO Exception");
		}

		return vendorId;
	}
	public void insertVendorDetails(VendorTO vendorTO) throws DatabaseExceptions {
		// TODO Auto-generated method stub
		LOG.info("insertting vendor details");
		try {
			connection =DBUtil.getConnection();
			preparedSatement=connection.prepareStatement(QueryConstants.INSERT_VENDOR_DETAILS);
			preparedSatement.setInt(1,vendorTO.getVendorId());
			preparedSatement.setString(2,vendorTO.getVendorName());
			preparedSatement.setString(3,vendorTO.getVendorAddress());
			preparedSatement.setString(4, vendorTO.getVendorCity());
			preparedSatement.setString(5,vendorTO.getVendorEmail());
			preparedSatement.setString(6,vendorTO.getVendorContact());
			preparedSatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("class not found exception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("database exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("IO exception");
		}
		
	}

}
