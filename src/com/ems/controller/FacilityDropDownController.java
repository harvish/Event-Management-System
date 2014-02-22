package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bo.FacilityDropDownBO;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityDropDownTO;

/**
 * Servlet implementation class FacilityDropDownController
 */
public class FacilityDropDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityDropDownController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			response.setContentType("text");
			FacilityDropDownBO dropdownBO=new FacilityDropDownBO();
			FacilityDropDownTO dropdownTO=new FacilityDropDownTO();
			dropdownBO.getFacilityname(dropdownTO);
			String jsonString="[{'facilityName':'"+dropdownTO.getFacilityName()+"','facilityCode':'"+dropdownTO.getFacilityCode()+"'}]";
			PrintWriter out=response.getWriter();
			//out.print(dropdownTO.getFacilityCode()+"*"+dropdownTO.getFacilityName());
			out.println(jsonString);
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
