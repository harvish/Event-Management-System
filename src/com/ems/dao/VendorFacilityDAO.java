package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ems.constants.QueryConstants;
import com.ems.exceptions.ApplicationException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorFacilityTO;
import com.ems.util.DBUtil;

public class VendorFacilityDAO {
	Connection connection=null;
	PreparedStatement preparedSatement=null;
	ResultSet resultSet=null;
	private static final Logger LOG = Logger.getLogger("Vendor Facility Screen");

	public void getFacilityId(VendorFacilityTO vendorfacilityTO) throws DatabaseExceptions{
		// TODO Auto-generated method stub
		LOG.info("getting facility id");
		try {
			connection=DBUtil.getConnection();
			preparedSatement=connection.prepareStatement(QueryConstants.GET_FACILITY_ID);
			preparedSatement.setString(1,""+vendorfacilityTO.getVendorId()+"%");
			resultSet=preparedSatement.executeQuery();
			while(resultSet.next())
			{
				vendorfacilityTO.setFacilityID(resultSet.getString(1));
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		throw new DatabaseExceptions("class not found Exception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("Database Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("IO Exception");
		}
		
	}

	public void insertVendorFacility(VendorFacilityTO vendorfacilityTO) throws DatabaseExceptions, ApplicationException
		 {
		// TODO Auto-generated method stub
		try {
			connection=DBUtil.getConnection();
			String[] facilityCode=vendorfacilityTO.getFacilityName();
			String facilityCost[]=vendorfacilityTO.getFacilityCost();
			for(int i=0;i<facilityCost.length && !facilityCost[i].isEmpty();i++)
			{
			String facilityId=incrementFacilityId(vendorfacilityTO,i+1);
	//		System.out.println(facilityId+""+facilityCode[i]+""+facilityCost[i]);
			preparedSatement=connection.prepareStatement(QueryConstants.INSERT_VENDOR_FACILITY_DETAILS);
			preparedSatement.setString(1,facilityId);
			preparedSatement.setInt(2,vendorfacilityTO.getVendorId());
			preparedSatement.setString(3,facilityCode[i]);
			preparedSatement.setInt(4, Integer.parseInt(facilityCost[i]));
			preparedSatement.execute();
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("class not found Exception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("Database Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("Database Exception");
		}
		
		
		
	}
	public String incrementFacilityId(VendorFacilityTO vendorfacilityTO,int counter) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		String n=String.valueOf(vendorfacilityTO.getVendorId());
		//System.out.println(vendorfacilityTO.getFacilityID());
		int Id=Integer.parseInt(vendorfacilityTO.getFacilityID().substring(n.length(),vendorfacilityTO.getFacilityID().length()));
		Id=Id+counter;
		String facilityId=n+Id;
		return facilityId;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Null pointer exception or no values in database");
		}
		}
	}


