package com.ems.constants;

public class QueryConstants {
	public static final String INSERT_EVENT="insert into event(event_id,customer_id," +
	"event_name,start_date,end_date,event_code,venue_id,start_time,end_time,budget_amount) " +
	"values(?,?,?,?,?,?,?,?,?,?);";
	public static final String GET_EVENT_ID = "select max(cast(substring(event_id,-4) as unsigned)) from event"; 
public static String GET_VENDOR_ID="select max(vendor_id) from vendor_details";
	
	public static String INSERT_VENDOR_DETAILS="insert into vendor_details values(?,?,?,?,?,?)";
	
	public static String GET_FACILITY_DETAILS="select * from facility_type";

	public static String GET_FACILITY_ID="select max(facility_id) from vendor_facility where facility_id like ?";
	
	public static String INSERT_VENDOR_FACILITY_DETAILS="insert into vendor_facility values(?,?,?,?)";

}
