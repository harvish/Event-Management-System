package com.ems.bo;

import com.ems.dao.FacilityDropDownDAO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityDropDownTO;

public class FacilityDropDownBO {
FacilityDropDownDAO dropdownDAO=new FacilityDropDownDAO();
	public void getFacilityname(FacilityDropDownTO dropdownTO) throws DatabaseExceptions {
		// TODO Auto-generated method stub
		dropdownDAO.getFacilityName(dropdownTO);
		
		
	}

}
