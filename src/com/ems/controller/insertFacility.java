package com.ems.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.Facility;
import com.ems.exceptions.DatabaseExceptions;

/**
 * Servlet implementation class insertFacility
 */
public class insertFacility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertFacility() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customer_id=request.getParameter("customer_id");
		String[] facility_code=request.getParameterValues("tfIdName");
		String[] vendor_id=request.getParameterValues("vendor_id");
		String[] quantity=request.getParameterValues("quantity");
		String event_id=request.getParameter("event_id");
		Facility f=new Facility();
		try {
		
			for(int i=0;i<facility_code.length;i++)
			{
				/*System.out.println(customer_id);
				System.out.println(event_id);
				System.out.println(facility_code[i]);
				System.out.println(vendor_id[i]);
				System.out.println(quantity[i]);
				*/
				f.insertfacility(customer_id, event_id, facility_code[i], vendor_id[i], quantity[i]);
			}
		} catch (DatabaseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
