package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bo.CustomerBo;
import com.ems.constants.ErrorConstants;
import com.ems.constants.SuccessConstants;
import com.ems.dao.CustomerRegistrationDao;
import com.ems.exceptions.ApplicationException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.CustomerDetailsTo;

/**
 * Servlet implementation class CustomerRegistrationController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String custName = request.getParameter("cname");
		String custAddress = request.getParameter("caddress");
		String custMember = request.getParameter("member");
		String expiryDate = request.getParameter("edate");
		String custCity = request.getParameter("ccity");
		String custEmail = request.getParameter("cemail");
		String custContact = request.getParameter("ccontact");
		CustomerDetailsTo cdto = new CustomerDetailsTo();
		CustomerDetailsTo ncdto = new CustomerDetailsTo();
		cdto.setCustomerName(custName);
		cdto.setCustomerAddress(custAddress);
		cdto.setCustomerMembership(custMember);
		
		if(expiryDate=="")
		{
			cdto.setExpiryDate(null);
		}
		else
		{
			Date exdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			
			try {
				exdate = sdf.parse(expiryDate);
				cdto.setExpiryDate(exdate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				try {
					throw new ApplicationException(ErrorConstants.DATEFORMAT_ERROR);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					request.getSession().setAttribute("errorMessage", e.getMessage());
					RequestDispatcher view = request.getRequestDispatcher("error.jsp");
					view.forward(request, response);
					//e.printStackTrace();
				}
				//e1.printStackTrace();
			}
		}
		cdto.setCustomerCity(custCity);
		cdto.setCustomerEmail(custEmail);
		cdto.setCustomerContactNo(custContact);
		
		String res="";
		PrintWriter out =  response.getWriter();
		CustomerBo crbo = new CustomerBo();
		CustomerRegistrationDao crdao = new CustomerRegistrationDao();
		try {
			
				ncdto = crbo.generateCustomerId(cdto);
				boolean b = crdao.insertCustomerDetails(ncdto);
				
			if(b==false)
			{
				request.getSession().setAttribute("successMessage", SuccessConstants.REGISTRATION_SUCCESS);
				res="pass";
				out.print(res);
			}
			else
			{
				request.getSession().setAttribute("errorMessage", ErrorConstants.INSERTION_ERROR);
				res="fail";
				out.print(res);
			}
		
		} catch (DatabaseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getSession().setAttribute("errorMessage", e.getMessage());
			res="fail";
			out.print(res);
		}
	}

}
