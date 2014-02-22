package com.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.ReportsTO;
import com.ems.util.DBUtil;

public class ReportsDAO {

	private static final Logger LOG = Logger.getLogger("Reports DAO");
public String getReport(ReportsTO rto) throws DatabaseExceptions
{
	LOG.info("get report");
	String fr=rto.getFrom_date();
	String to=rto.getTo_date();
	
	//System.out.println("dao");
	String s="";
	try {
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("select event_id,start_date,event_name,venue_name,budget_amount from  `ems`.`event` join venue using (venue_id) where start_date between cast(? as date) and cast(? as date);");
		ps.setString(1,fr);
		ps.setString(2,to);
		ResultSet rs=ps.executeQuery();
		s="{\"table\":["; 
		while(rs.next())
		{
		s=s+"{\"eventid\":\""+rs.getString(1)+"\",\"date\":\""+rs.getString(2)+"\",\"eventname\":\""+rs.getString(3)+"\",\"venuename\":\""+rs.getString(4)+"\",\"totalamount\":\""+rs.getString(5)+"\"},"; 
		}
//		System.out.println(x);
		s=s+"]}";
//		System.out.println("222"+s);
		String s1="";
		if(s.indexOf('[')+1!=s.lastIndexOf(']'))
		{
//		System.out.println("if");
		StringBuffer sb =new StringBuffer(s);
		sb.deleteCharAt(sb.length()-3);
//		System.out.println("tostrin "+sb.toString());
		s1=sb.toString();}
		else
			s1=s;
		return s1;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		throw new DatabaseExceptions("Class not found exception");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DatabaseExceptions("database exception");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		throw new DatabaseExceptions("IO exception");
	}
	
}
	
}
