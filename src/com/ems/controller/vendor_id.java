package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.Facility;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.FacilityTo;

/**
 * Servlet implementation class vendor_id
 */
public class vendor_id extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vendor_id() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String facility=request.getParameter("facility");
		Facility f=new Facility();
		ArrayList<FacilityTo> fdao=new ArrayList<FacilityTo>();
		StringBuffer sb=new StringBuffer();
		try {
			fdao=f.getVendorId(facility);
		} catch (DatabaseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer=response.getWriter();
		for(int i=0;i<fdao.size();i++)
		{
			sb.append(fdao.get(i).getVendor_id());
			sb.append("+");
		}
		String jsplis1=new String(sb);
//		System.out.println(jsplis1);
		writer.println(jsplis1);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
