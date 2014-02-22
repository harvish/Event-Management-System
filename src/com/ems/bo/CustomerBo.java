package com.ems.bo;

import com.ems.dao.CustomerRegistrationDao;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.CustomerDetailsTo;

public class CustomerBo {

	public CustomerDetailsTo generateCustomerId(CustomerDetailsTo cdto) throws DatabaseExceptions 
	{	
		CustomerRegistrationDao crdao = new CustomerRegistrationDao();
		cdto = crdao.getCustId(cdto);
		return cdto;		
	}	
	
}
