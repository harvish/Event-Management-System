package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bo.ReportsBO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.ReportsTO;

/**
 * Servlet implementation class ReportsController
 */
public class ReportsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out= response.getWriter();	
//	System.out.println("servet hit");
	
	String from=request.getParameter("from");
	String to=request.getParameter("to");
	
	ReportsTO rto=new ReportsTO();
	rto.setFrom_date(from);
	rto.setTo_date(to);
	
	
	
	
	ReportsBO obj=new ReportsBO();
	String rep= null;
	try {
		rep = obj.report(rto);
	} catch (DatabaseExceptions e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	System.out.println(rep);
	response.setContentType("application/json");
	out.print(rep);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
