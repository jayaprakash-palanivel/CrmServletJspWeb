package com.techymeet.crm.controller;

import java.io.IOException;

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
 * Servlet implementation class CreateLeads
 */
@WebServlet("/createLeads")
public class CreateLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/create_leads.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String emailAddress=request.getParameter("emailAddress");
		String mobileNumber=request.getParameter("mobileNumber");
		long mobilnum=Long.parseLong(mobileNumber);
		String companyName=request.getParameter("companyName");
		String salary=request.getParameter("salary");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		
		LeadsBo leadsBo=new LeadsBo();
		leadsBo.setFirstName(firstName);
		leadsBo.setLastName(lastName);
		leadsBo.setEmailAddress(emailAddress);
		leadsBo.setMobileNumber(mobilnum);
		leadsBo.setCompanyName(companyName);
		leadsBo.setSalary(salary);
		leadsBo.setAddress(address);
		leadsBo.setCity(city);
		leadsBo.setState(state);
		leadsBo.setCountry(country);
		
		int status=leadsservice.createLeads(leadsBo);
		if (0 < status) {
			request.setAttribute("successMessage", "Leads created successfully!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/listLeads");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Leads creation Failed!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/create_leads.jsp");
			dispatcher.forward(request, response);
		}

		
		
		
		
		
		
		
	}

}
