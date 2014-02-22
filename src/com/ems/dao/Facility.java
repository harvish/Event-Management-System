package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityTo;
import com.ems.util.DBUtil;

public class Facility {
	private static final Logger LOG = Logger.getLogger("Facility DAO");
	public ArrayList<FacilityTo> vendorId(String customer_id) throws DatabaseExceptions
	{
		LOG.info("Facility DAO");
		Connection connection;
		ArrayList<FacilityTo> al;
		try {
			connection = DBUtil.getConnection();
			al = new ArrayList<FacilityTo>();	
			ResultSet rs=null;
			PreparedStatement ps=null;
			String sql="select event_id from event where customer_id=?" ;
			//int c=0;
			FacilityTo fto;
				
				
			ps=connection.prepareStatement(sql);
			ps.setString(1,customer_id);	
			rs=ps.executeQuery();
			while(rs.next())
			{
				fto=new FacilityTo();
				fto.setEvent_id(rs.getString(1));
				al.add(fto);
			}
//			for(FacilityTo fto1:al)
			{
	//		System.out.println(fto1.getEvent_id());	
			}
			
			connection.close();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return al;
	}

	public ArrayList<FacilityTo> faciltyDesc() throws DatabaseExceptions 
	{
		LOG.info("inside facility Desc");
		ArrayList<FacilityTo> al1=new ArrayList<FacilityTo>();	
		
		try {
			Connection connection=DBUtil.getConnection();
			
		//	System.out.println(connection);
			ResultSet rs=null;
			PreparedStatement ps=null;
			String sql="select facility_type from facility_type " ;
				
			FacilityTo fto;
				
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			//System.out.println(rs);
			while(rs.next())
			{
				fto=new FacilityTo();
				fto.setFacility_desc(rs.getString(1));
				al1.add(fto);
			}
	//		for(FacilityTo fto1:al1)
			{
//				System.out.println(fto1.getFacility_desc());	
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return al1;
	}

	public ArrayList<FacilityTo> getVendorId(String facility_desc) throws DatabaseExceptions 
	{
		LOG.info("Vendor Id DAO");
		ArrayList<FacilityTo> al1=new ArrayList<FacilityTo>();	
		
		try {
			Connection connection=DBUtil.getConnection();
			
		//	System.out.println(connection);
			ResultSet rs=null;
			PreparedStatement ps=null;
			String sql="select vendor_id from vendor_facility where facility_code=(select facility_code from facility_type where facility_type=? )" ;
			
			FacilityTo fto;
			
			
				ps=connection.prepareStatement(sql);
				ps.setString(1, facility_desc);	
				rs=ps.executeQuery();
			
//			System.out.println(rs);

		while(rs.next())
		{
			fto=new FacilityTo();
			fto.setVendor_id(rs.getString(1));
			al1.add(fto);
		}
	//	for(FacilityTo fto1:al1)
		{
		//			System.out.println(fto1.getVendor_id());	
		}
		
		connection.close();
	} catch (ClassNotFoundException e) {
		throw new DatabaseExceptions("class not found");
	} catch (IOException e) {
		throw new DatabaseExceptions("IO exception");
	} catch (SQLException e) {
		throw new DatabaseExceptions("SQL Exception");
	}
		return al1;
	}
	
	public ArrayList<FacilityTo> getCost(String vendor_id,String facility) throws DatabaseExceptions
	{
		LOG.info("cost Dao");
		ArrayList<FacilityTo> al1=new ArrayList<FacilityTo>();	
		
		try{
			Connection connection=DBUtil.getConnection();
			ResultSet rs=null;
			PreparedStatement ps=null;
			String sql="select cost from vendor_facility where vendor_id=? and facility_code=(select facility_code from facility_type where facility_type=?)" ;
			FacilityTo fto;
			ps=connection.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(vendor_id));	
			ps.setString(2, facility);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				fto=new FacilityTo();
				fto.setCost(rs.getInt(1));
				al1.add(fto);
			}
		
			//for(FacilityTo fto1:al1)
			{
				//System.out.println(fto1.getCost());	
			}
			
			connection.close();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return al1;
	}

	public void insertfacility(String customer_id,String event_id,String facility_code,String vendor_id,String required_quantity) throws DatabaseExceptions
	{
		LOG.info("insert Facility DAO");
		try{
			
			String facilitycode = facilityCode(facility_code);
	//		System.out.println(facility_code);
			Connection connection=DBUtil.getConnection();
			
			PreparedStatement ps=null;
			String sql="insert into facility_details(customer_id,event_id,facility_code,vendor_id,required_quantity) values(?,?,?,?,?)" ;
			
			//FacilityTo fto;
			ps=connection.prepareStatement(sql);
			ps.setString(1, customer_id);	
			ps.setString(2, event_id);
			ps.setString(3, facilitycode);
			ps.setString(4, vendor_id);
			ps.setInt(5, Integer.parseInt(required_quantity));
			ps.executeUpdate();
		
			connection.close();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
	}
	public String facilityCode(String facility_name) throws DatabaseExceptions 
	{
		LOG.info("in facility code dao");
		String facility_code;
		try {
			Connection connection=DBUtil.getConnection();
			//System.out.println(vendor_id);
			//System.out.println("getfacility code");
			
			PreparedStatement ps=null;
			String sql="select facility_code from facility_type where facility_type=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, facility_name);
			ResultSet rs = ps.executeQuery();
			FacilityTo ft=new FacilityTo();
			while(rs.next())
			{
				ft.setFacility_code(rs.getString(1));
			}
			facility_code = ft.getFacility_code();
			connection.close();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return facility_code;
	}
	public  ArrayList<FacilityTo> customerList() throws DatabaseExceptions
	{
		ArrayList<FacilityTo> al=new ArrayList<FacilityTo>();	
		LOG.info("in customer List DAO");
		try {
			Connection connection=DBUtil.getConnection();
			ResultSet rs=null;
			PreparedStatement ps=null;
			String sql="select customer_id from event" ;
		//	int c=0;
			FacilityTo fto;
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				fto=new FacilityTo();
				fto.setCustomer_id(rs.getString(1));
				al.add(fto);
			}
		//	for(FacilityTo fto1:al)
			{
			//	System.out.println(fto1.getCustomer_id());	
			}
		connection.close();
			
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
	
	return al;

	}
	
}
