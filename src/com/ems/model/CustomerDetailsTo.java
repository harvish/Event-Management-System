package com.ems.model;

import java.util.Date;

public class CustomerDetailsTo {
	
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerMembership;
	private Date expiryDate;
	private String customerCity;
	private String customerEmail;
	private String customerContactNo;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerMembership() {
		return customerMembership;
	}
	public void setCustomerMembership(String customerMembership) {
		this.customerMembership = customerMembership;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerContactNo() {
		return customerContactNo;
	}
	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	@Override
	public String toString() {
		return "CustomerDetailsTo [customerId=" + customerId
				+ ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerMembership="
				+ customerMembership + ", expiryDate=" + expiryDate
				+ ", customerCity=" + customerCity + ", customerEmail="
				+ customerEmail + ", customerContactNo=" + customerContactNo
				+ "]";
	}
	
	
	
}
