package com.ems.bo;

import com.ems.dao.VendorDAO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorTO;

public class VendorBO {
	VendorDAO vendorDAO=new VendorDAO();
	public void insertVendorDetails(VendorTO vendorTO) throws DatabaseExceptions {
		int vendorIdGenerator=getVendorID();
		if(vendorIdGenerator==0)
		{
			vendorTO.setVendorId(1001);
		}
		else
		{
		vendorTO.setVendorId(vendorIdGenerator+1);
		}
		vendorDAO.insertVendorDetails(vendorTO);
		
	}

	private int getVendorID() throws DatabaseExceptions {
			
		int vendorId=vendorDAO.getVendorID();
		
		return vendorId;
	}

}
