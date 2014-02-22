package com.ems.bo;

import com.ems.dao.ReportsDAO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.ReportsTO;

public class ReportsBO {





public String report(ReportsTO rto) throws DatabaseExceptions
{
//	System.out.println("bo");
	ReportsDAO obj=new ReportsDAO();
	String reportres=obj.getReport(rto);
	
	
	
	return reportres;
	

	
	
	
}
	
	
}
