package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bo.EventBO;
import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;

/**
 * Servlet implementation class CustomerCheck
 */
public class CustomerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			new EventBO().checkCustomerID(request.getParameter("customer_id"));
		} catch (BusinessException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Customer ID Invalid");
		} catch (DatabaseExceptions e) {
			response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"Database Exception");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
