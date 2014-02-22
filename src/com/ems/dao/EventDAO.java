package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.apache.log4j.Logger;








import org.json.simple.JSONObject;

import com.ems.constants.QueryConstants;
import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.EventDetails;
import com.ems.util.DBUtil;

public class EventDAO {
	private static final Logger LOG = Logger.getLogger("Event DAO");
	public void insertEvent(com.ems.model.EventDetails event) throws DatabaseExceptions
	{
		LOG.info("inside event dao");
		try {
			Connection con=DBUtil.getConnection();
			System.out.println("dao");
			PreparedStatement ps= con.prepareStatement(QueryConstants.INSERT_EVENT);
			Calendar cal=Calendar.getInstance();
			cal.setTime(event.getStartDate());
			String eventId=null;
			eventId=event.getEventType()+new SimpleDateFormat("MMM").format(cal.getTime()).toUpperCase()+getUniqueID();
			ps.setString(1, eventId);
			ps.setString(2, event.getCustomerId());
			ps.setString(3, event.getName());
			ps.setDate(4, event.getStartDate());
			ps.setDate(5,event.getEndDate());
			ps.setString(6, event.getEventType());
			ps.setString(7, event.getVenueId());
			ps.setInt(8, event.getStartTime());
			ps.setInt(9,event.getEndTime());
			ps.setInt(10, event.getBudget());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
	}
	private int getUniqueID() throws DatabaseExceptions
	{
		LOG.info("Unique Id");
		int id=0;
		try{
			Connection con=DBUtil.getConnection();
			PreparedStatement ps= con.prepareStatement(QueryConstants.GET_EVENT_ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getInt(1)+1;
			}
			else
			{
				id=1001;
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return id;
	}
	public String venueDetails(int venue_id) throws DatabaseExceptions
	{
		LOG.info("Venue Details DAO");
		StringBuffer sb= new StringBuffer();
		try{
			Connection con=DBUtil.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from venue where venue_id=?");
			ps.setInt(1, venue_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				sb.append("{\"venue_id\":\""+rs.getString(1)+"\",\"venue_name\":\""+
						rs.getString(2)+"\",\"location\":\""+rs.getString(3)+"\",\"cost\":\""+
						rs.getString(4)+"\"}");
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return sb.toString();
	}
	public void checkCustomer(String customerId) throws BusinessException, DatabaseExceptions {
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from customer_details where customer_id=?");
			ps.setString(1, customerId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
			}
			else {
				throw new BusinessException("Customer ID invalid");
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
			}
	public void editEvent(EventDetails event) throws DatabaseExceptions {
		LOG.info("inside event edit  dao");
		try {
			Connection con=DBUtil.getConnection();
	//		System.out.println("dao");
			PreparedStatement ps= con.prepareStatement("UPDATE `event` SET event_name=?, start_date=?, end_date=?, event_code=?, venue_id=?, start_time=?, budget_amount=?, end_time=? WHERE customer_id=? AND event_id=?");
			ps.setString(1, event.getName());
			ps.setDate(2, event.getStartDate());
			ps.setDate(3, event.getEndDate());
			ps.setString(4, event.getEventType());
			ps.setString(5,event.getVenueId());
			ps.setInt(6, event.getStartTime());
			ps.setInt(7, event.getBudget());
			ps.setInt(8, event.getEndTime());
			ps.setString(9,event.getCustomerId());
			ps.setString(10, event.getEventId());
		//	System.out.println(ps.toString());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		
	}
	public String fetchEventDetails(String customerId, String eventId) throws BusinessException {
		LOG.info("inside event Fetch");
		JSONObject st= new JSONObject();
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT customer_id,event_id,event_name,start_date"
					+ ",end_date,event_code,venue_id,start_time,end_time,budget_amount FROM `event` where customer_id=? and event_id=?;");
			ps.setString(1, customerId);
			ps.setString(2, eventId);
			ResultSet rs= ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int col=rsmd.getColumnCount();
			if(rs.next())
			{
			for(int i=1;i<=col;i++)
				{
					st.put(rsmd.getColumnName(i),rs.getString(i));
				}
			}
			else {
				throw new BusinessException("Invalid Event Details");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return st.toJSONString();
		
	}
}
