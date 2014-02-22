package com.ems.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ems.bo.EventBO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.EventDetails;

/**
 * Servlet implementation class EventRegistration
 */
public class EventRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("EventRegistration controller class");
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventRegistration() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDetails event= new EventDetails();
		event.setCustomerId(request.getParameter("customer_id"));
		event.setName(request.getParameter("event_name"));
		event.setEventType(request.getParameter("event_type"));
		//System.out.println(request.getParameter("customer_id")+request.getParameter("event_name")+request.getParameter("event_type"));
		try {
			event.setStartDate(request.getParameter("start_date"));
			event.setEndDate(request.getParameter("end_date"));
		} catch (ParseException e) {
			LOG.error("Parse Exception occured");
		}
		event.setVenueId(request.getParameter("venue_id"));
		try{
			event.setStartTime(Integer.parseInt(request.getParameter("start_time")));
			event.setEndTime(Integer.parseInt(request.getParameter("end_time")));
			event.setBudget(Integer.parseInt(request.getParameter("budget")));
		} catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
//	 System.out.println(event);
		try {
			new EventBO().addEvent(event);
		} catch (DatabaseExceptions e) {
			e.printStackTrace();
		}
	}

}
