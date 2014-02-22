package com.ems.bo;

import com.ems.dao.VendorFacilityDAO;
import com.ems.exceptions.ApplicationException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorFacilityTO;

public class VendorFacilityBO {
	VendorFacilityDAO vendorfacilityDAO=new VendorFacilityDAO();

	public void insertVendorFacility(VendorFacilityTO vendorfacilityTO) throws DatabaseExceptions, ApplicationException {
		// TODO Auto-generated method stub
		vendorfacilityDAO.getFacilityId(vendorfacilityTO);
		if(vendorfacilityTO.getFacilityID()==null)
		{
			vendorfacilityTO.setFacilityID(vendorfacilityTO.getVendorId()+"1000");
		}
		vendorfacilityDAO.insertVendorFacility(vendorfacilityTO); 
	}

	
}
