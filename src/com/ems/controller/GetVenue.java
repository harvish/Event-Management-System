package com.ems.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EventDAO;
import com.ems.exceptions.DatabaseExceptions;

/**
 * Servlet implementation class GetVenue
 */
public class GetVenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVenue() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String res=new EventDAO().venueDetails(Integer.parseInt(request.getParameter("venue_id")));
			response.setContentType("application/json");
			response.getWriter().write(res);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DatabaseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
