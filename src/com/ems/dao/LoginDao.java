package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.util.DBUtil;


public class LoginDao {
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

private static final Logger LOG = Logger.getLogger("Login DAO");
	public void getLoginDetails(String userid, String pass) throws DatabaseExceptions, BusinessException 
	{
		LOG.info("login validating");
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("Select * from login where userid=? and pass=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				
			}
			else {
				throw new BusinessException("Login Incorrect");
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseExceptions("class not found");
		} catch (IOException e) {
			throw new DatabaseExceptions("IO exception");
		} catch (SQLException e) {
			throw new DatabaseExceptions("SQL Exception");
		}
	}
}
