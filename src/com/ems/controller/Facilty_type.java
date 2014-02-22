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
 * Servlet implementation class Facilty_type
 */
public class Facilty_type extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facilty_type() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Facility f=new Facility();
		StringBuffer sb=new StringBuffer();
		ArrayList<FacilityTo> al1=new ArrayList<FacilityTo>();
		try {
			al1=f.faciltyDesc();
		} catch (DatabaseExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer=response.getWriter();
		for(int i=0;i<al1.size();i++)
		{
			
			sb.append(al1.get(i).getFacility_desc());
			sb.append("+");
		}
		String jsplis1=new String(sb);
		//System.out.println(jsplis1);
	writer.println(jsplis1);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
