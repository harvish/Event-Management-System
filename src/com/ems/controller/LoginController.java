package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.bo.LoginBo;
import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.LoginTo;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String logout = req.getParameter("logout");
		String lout="";
		PrintWriter out = resp.getWriter();
		if(logout.equals("LOGOUT"))
		{   
			HttpSession session=req.getSession(false);
			session.invalidate();
			resp.setContentType("text");
			lout="pass";
			out.print(lout);
			//RequestDispatcher view = req.getRequestDispatcher("login.jsp");
			//view.forward(req, resp);
		}
		else
		{
			lout="fail";
			out.print(lout);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		HttpSession session=null;
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		LoginTo lto = new LoginTo();
		lto.setUserName(userName);
		lto.setPassword(password);
		
		LoginBo lbo = new LoginBo();
		try {
			lbo.checkUserPassword(lto);
		//	PrintWriter out = response.getWriter();
		//	String qw="";
			
			session=request.getSession(true);
		    session.setAttribute("username",userName);  
		    session.setMaxInactiveInterval(5*60);
		} catch (DatabaseExceptions e) {
			response.sendRedirect("error.jsp?e="+e.getMessage());
		} catch (BusinessException e) {
			response.sendRedirect("login.jsp?invalid");
		}
		
		
		
	}

}
