package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.CustomerDetailsTo;
import com.ems.util.DBUtil;

public class CustomerRegistrationDao {
 Connection con = null;
 PreparedStatement ps = null;
 ResultSet rs = null;
 private static final Logger LOG = Logger.getLogger("");
 public CustomerDetailsTo getCustId(CustomerDetailsTo cdto) throws DatabaseExceptions
	{
		LOG.info("Customer ID DAO");
		String extrCity;
		ArrayList<String> custIdList;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select customer_id from customer_details");
			rs = ps.executeQuery();
			String custCity = cdto.getCustomerCity();
			extrCity = custCity.substring(0, 3);
			custIdList = new ArrayList<String>();
			while(rs.next())
			{
				custIdList.add(rs.getString(1));
			}
		
	    int max = -1;
	    boolean flag = false;
	    for(int i=0;i<custIdList.size();i++)
	    {
	    	if(custIdList.get(i).substring(0, 3).equalsIgnoreCase(extrCity))
	    	{
	    		int num = Integer.parseInt(custIdList.get(i).substring(3));
	    		if(num>max)
	    		{
	    			max=num;
	    		}
	    		flag = true;
	    	}
	    		
	    }
	    if(flag == false)
	    {
	    	StringBuffer sb = new StringBuffer();
		    sb.append(extrCity.toUpperCase()).append(1001);
		    cdto.setCustomerId(sb.toString());
	    }
	   // System.out.println(max);
	    else
	    {
	    StringBuffer sb = new StringBuffer();
	    sb.append(extrCity.toUpperCase()).append(max+1);
	    cdto.setCustomerId(sb.toString());
	    }
	    con.close();
	    ps.close();
	    rs.close();
		
	} catch (ClassNotFoundException e) {
		throw new DatabaseExceptions("class not found");
	} catch (IOException e) {
		throw new DatabaseExceptions("IO exception in Database properties");
	} catch (SQLException e) {
		throw new DatabaseExceptions("SQL Exception occured");
	}
	
	return cdto;
	}
 	
 	public boolean insertCustomerDetails(CustomerDetailsTo cdto) throws DatabaseExceptions  
 	{
 	LOG.info("insert Customer DAO");
	boolean b;
	try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?)");
		
		ps.setString(1,cdto.getCustomerId());
		ps.setString(2, cdto.getCustomerName());
		ps.setString(3, cdto.getCustomerAddress());
		ps.setString(4, cdto.getCustomerMembership());
		if(cdto.getExpiryDate()!=null)
		{
		java.sql.Date exdate=new java.sql.Date(cdto.getExpiryDate().getTime());
		ps.setDate(5, exdate);
		}
		else
		{
			ps.setDate(5, null);
		}
		ps.setString(6, cdto.getCustomerCity());
		ps.setString(7, cdto.getCustomerEmail());
		ps.setString(8, cdto.getCustomerContactNo());
		
		b = ps.execute();
		con.close();
		ps.close();
	} catch (ClassNotFoundException e) {
		throw new DatabaseExceptions("class not found");
	} catch (IOException e) {
		throw new DatabaseExceptions("IO exception in Database properties");
	} catch (SQLException e) {
		throw new DatabaseExceptions("SQL Exception occured");
	}
 		
	return b;
 	}
	
}
