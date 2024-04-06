package com.techymeet.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.service.LeadsService;
import com.techymeet.crm.service.LeadsServiceImpl;

/**
 * Servlet implementation class SearchLeads
 */
@WebServlet("/searchLeads")
public class SearchLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LeadsBo leadsBo=new LeadsBo();
		
		
		if(!request.getParameter("firstName").isEmpty() || !request.getParameter("emailAddress").isEmpty()) {
			
			if (null != request.getParameter("LeadsBo") && !request.getParameter("LeadsBo").isEmpty()) {
				String firstName = request.getParameter("LeadsBo");
				leadsBo.setFirstName(firstName);
			}
			if (null != request.getParameter("emailAddress") && !request.getParameter("emailAddress").isEmpty()) {
				String email = request.getParameter("emailAddress");
				leadsBo.setEmailAddress(email);
			}
			
			List<LeadsBo> leadsList = leadsservice.searchLeads(leadsBo);
			if (null != leadsList && 0 < leadsList.size()) {
				request.setAttribute("leadsList", leadsList);
				request.setAttribute("search", "search");
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_leads.jsp");
				dispatch.forward(request, response);
			}else {
				request.setAttribute("errorMessage", "No Record Found!");
				request.setAttribute("search", "search");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_leads.jsp");
				dispatch.forward(request, response);
			} 
			
		} else {
		request.setAttribute("errorMessage", "Please enter something to search!");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/listLeads");
		dispatcher.forward(request, response);
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
