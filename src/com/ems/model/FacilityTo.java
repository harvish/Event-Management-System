package com.ems.model;

public class FacilityTo {
	private String customer_id;
	private String event_id;
	private String facility_description;
	private String vendor_id;
	private int cost;
	private int quantity;
	private String facility_desc;
	private String facility_code;
	
	public String getFacility_code() {
		return facility_code;
	}
	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
	}
	public String getFacility_desc() {
		return facility_desc;
	}
	public void setFacility_desc(String facility_desc) {
		this.facility_desc = facility_desc;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getFacility_description() {
		return facility_description;
	}
	public void setFacility_description(String facility_description) {
		this.facility_description = facility_description;
	}
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
