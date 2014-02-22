package com.ems.model;

public class VendorFacilityTO {
	private String facilityName[];
	private String facilityCost[];
	private String facilityID;
	private int vendorId;
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String[] getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String[] facilityName) {
		this.facilityName = facilityName;
	}
	public String[] getFacilityCost() {
		return facilityCost;
	}
	public void setFacilityCost(String[] facilityCost) {
		this.facilityCost = facilityCost;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	

}
