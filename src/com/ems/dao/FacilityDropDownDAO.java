package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ems.constants.QueryConstants;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityDropDownTO;
import com.ems.util.DBUtil;

public class FacilityDropDownDAO {
Connection connection=null;
PreparedStatement preparedStatement=null;
ResultSet resultSet=null;
	private static final Logger LOG = Logger.getLogger("");
public void getFacilityName(FacilityDropDownTO dropdownTO) throws DatabaseExceptions{
		// TODO Auto-generated method stub
		LOG.info("facility controller drop down dao");
	StringBuffer facilityCode=new StringBuffer();
		StringBuffer facilityName=new StringBuffer();
		try {
			connection=DBUtil.getConnection();
			preparedStatement=connection.prepareStatement(QueryConstants.GET_FACILITY_DETAILS);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
			facilityCode.append(resultSet.getString(1)+" ");
			facilityName.append(resultSet.getString(2)+"/");
			}
			dropdownTO.setFacilityCode(facilityCode.toString());
			dropdownTO.setFacilityName(facilityName.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("Class not found exception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("Database Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DatabaseExceptions("IO Exception");
		}
		
	}

}
