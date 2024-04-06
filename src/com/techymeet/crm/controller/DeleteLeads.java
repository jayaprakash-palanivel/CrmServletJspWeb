package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.service.LeadsService;
import com.techymeet.crm.service.LeadsServiceImpl;

/**
 * Servlet implementation class DeleteLeads
 */
@WebServlet("/deleteLeads")
public class DeleteLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		String leadsId=request.getParameter("leadsId");
		int leadId=Integer.valueOf(leadsId);
		
		boolean status=leadsservice .deleteLeads(leadId);
		 
		if(status) {
	 		
	 		 request.setAttribute("successMessage","leads Account Deleted successfully!");
			    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listLeads");
				dispatcher.forward(request,response);
	 	}else {
	 		request.setAttribute("errorMessage","leads Account Deletion Failed!");
     	    
			RequestDispatcher dispatcher=request.getRequestDispatcher("/listLeads");
			dispatcher.forward(request,response);
	 	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
