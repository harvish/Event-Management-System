package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ems.dao.Facility;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityTo;

/**
 * Servlet implementation class Cost_controller
 */
public class Cost_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("Cost Controller");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cost_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside Cost controller");
		String facility=request.getParameter("facility");
		String vendor_id=request.getParameter("vendor_id");
	/*	System.out.println(facility);
		System.out.println(vendor_id);
	*/	StringBuffer sb=new StringBuffer();
	//	System.out.println("getmethod");
		Facility fdao=new Facility();
		ArrayList<FacilityTo> ft = null;
		try {
			ft=fdao.getCost(vendor_id, facility);
		} catch (DatabaseExceptions e) {
			LOG.error("Database Excpetion occured:"+e.getMessage());
		}
		PrintWriter writer=response.getWriter();
		sb.append(ft.get(0).getCost());
		String jsplis1=new String(sb);
//		System.out.println(jsplis1);
		writer.println(jsplis1);
	}

}
