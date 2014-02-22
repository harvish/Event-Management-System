package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.bo.VendorFacilityBO;
import com.ems.exceptions.ApplicationException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.VendorFacilityTO;

/**
 * Servlet implementation class VendorFacility
 */
public class VendorFacility extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public VendorFacility() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VendorFacilityTO vendorfacilityTO=new VendorFacilityTO();
		VendorFacilityBO vendorfailityBO=new VendorFacilityBO();
		String facilityName[]=request.getParameter("facility1").split(" ");
		String facilityCost[]=request.getParameter("faciltycost1").split(" ");
		vendorfacilityTO.setFacilityName(facilityName);
		vendorfacilityTO.setFacilityCost(facilityCost);
		HttpSession session=request.getSession();
//		System.out.println(session.getAttribute("vendorId"));
		
		try {
			vendorfacilityTO.setVendorId(Integer.parseInt(session.getAttribute("vendorId").toString()));
			vendorfailityBO.insertVendorFacility(vendorfacilityTO);
			PrintWriter out=response.getWriter();
			out.print("success");
			session.setAttribute("successMessage","values inserted successfully");
			/*request.setAttribute("successMessage","REGISTRATION WAS SUCCESSFUL");
			RequestDispatcher dispatcher=request.getRequestDispatcher(SuccessConstants.Success_page);
			dispatcher.forward(request,response);*/
			
		} catch (DatabaseExceptions databaseException) {
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			out.print("fail");
			session.setAttribute("errorMessage","sorry an error occured");
			/*request.setAttribute("errorMessage",databaseException.getMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher(ErrorConstants.Error_page);
			dispatcher.forward(request,response);*/
		} catch (ApplicationException applicationException) {
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			out.print("fail");
			session.setAttribute("errorMessage","sorry an error occured");
			/*request.setAttribute("errorMessage",applicationException.getMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher(ErrorConstants.Error_page);
			dispatcher.forward(request,response);*/
		}
		catch(Exception e)
		{
			try {
				throw new ApplicationException("session expired please log in again to continue");
			} catch (ApplicationException applicationException) {
				// TODO Auto-generated catch block
				PrintWriter out=response.getWriter();
				out.print("fail");
				session.setAttribute("errorMessage","sorry an error occured");
				/*request.setAttribute("errorMessage",applicationException.getMessage());
				RequestDispatcher dispatcher=request.getRequestDispatcher(ErrorConstants.Error_page);
				dispatcher.forward(request,response);*/
			}
		}
	}
}
