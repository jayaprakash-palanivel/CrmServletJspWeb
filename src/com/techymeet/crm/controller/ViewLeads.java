package com.techymeet.crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.service.LeadsService;
import com.techymeet.crm.service.LeadsServiceImpl;

/**
 * Servlet implementation class ViewLeads
 */
@WebServlet("/viewLeads")
public class ViewLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		 
		 if (null != session.getAttribute("loggedInUser")) {

			 String leadsId=request.getParameter("leadsId");
				int leadId=Integer.valueOf(leadsId);
				LeadsBo leadsBo=leadsservice.viewLeads(leadId);
				request.setAttribute("leadsBo", leadsBo);
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/view_leads.jsp");
				dispatch.forward(request, response);
			} else {

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/login.jsp");
				dispatch.forward(request, response);
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
