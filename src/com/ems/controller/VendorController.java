package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.bo.VendorBO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorTO;

/**
 * Servlet implementation class VendorController
 */
public class VendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VendorTO vendorTO=new VendorTO();
		VendorBO vendorBO=new VendorBO(); 
		vendorTO.setVendorName(request.getParameter("vendorName"));
		vendorTO.setVendorAddress(request.getParameter("vendorAddress"));
		vendorTO.setVendorCity(request.getParameter("vendorCity"));
		vendorTO.setVendorEmail(request.getParameter("vendorEmail"));
		vendorTO.setVendorContact(request.getParameter("vendorContact"));
		try {
			vendorBO.insertVendorDetails(vendorTO);
			HttpSession session=request.getSession(true);
			session.setAttribute("vendorId",vendorTO.getVendorId());
			response.setContentType("text");
			PrintWriter out=response.getWriter();
			session.setAttribute("vendorId",vendorTO.getVendorId());
			response.setContentType("text");
			out.println("vendor details has beeen inserted successfully and your genearated vendorID is "+vendorTO.getVendorId()+"");
	
			
		} catch (DatabaseExceptions databaseException) {
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			out.print("fail");
			/*request.setAttribute("errorMessage",databaseException.getMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher(ErrorConstants.Error_page);
			dispatcher.forward(request,response);*/
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
