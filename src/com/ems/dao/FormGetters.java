package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ems.exceptions.DatabaseExceptions;
import com.ems.util.DBUtil;


public class FormGetters {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private static final Logger LOG = Logger.getLogger("form getters");
	public Map<String, String> getEventTypes() throws DatabaseExceptions
	{
		LOG.info("formgetter event dao");
		Map<String,String> s = new HashMap<String, String>();
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("SELECT * FROM event_type");
			rs=ps.executeQuery();
			while(rs.next()) {
				s.put(rs.getString(1),rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return s;
	}
	public Map<String, String> getVenues() throws DatabaseExceptions
	{
		LOG.info("venue dao");
		Map<String,String> s = new HashMap<String, String>();
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("SELECT venue_id,venue_name FROM venue");
			rs=ps.executeQuery();
			while(rs.next()) {
				s.put(rs.getString(1),rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
		return s;
	}
}	
