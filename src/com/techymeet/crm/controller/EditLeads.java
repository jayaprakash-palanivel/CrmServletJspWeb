package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.service.LeadsService;
import com.techymeet.crm.service.LeadsServiceImpl;

/**
 * Servlet implementation class EditLeads
 */
@WebServlet("/editLeads")
public class EditLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (null != session.getAttribute("loggedInUser")) {
			String leadsId = request.getParameter("leadsId");
			int leadId = Integer.valueOf(leadsId);
			
			LeadsBo leadsBo = leadsservice.viewLeads(leadId);
			
			if (null != leadsBo) {
				request.setAttribute("editLeads", leadsBo);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/edit_leads.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Edit failed");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listLeads");
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("ErrorMessage", "EditProcessFailed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String leadsId = request.getParameter("leadsId");
		int leadId=Integer.valueOf(leadsId);
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String emailAddress=request.getParameter("emailAddress");
		String mobileNumber=request.getParameter("mobileNumber");
		String companyName=request.getParameter("companyName");
		String salary=request.getParameter("salary");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		
		LeadsBo leadsBo=new LeadsBo();
		
		leadsBo.setLeadsId(leadId);
		leadsBo.setFirstName(firstName);
		leadsBo.setLastName(lastName);
		leadsBo.setEmailAddress(emailAddress);
		leadsBo.setMobileNumber(new Long(mobileNumber));
		leadsBo.setCompanyName(companyName);
		leadsBo.setSalary(salary);
		leadsBo.setAddress(address);
		leadsBo.setCity(city);
		leadsBo.setState(state);
		leadsBo.setCountry(country);
		
		
		int status=leadsservice.editLeads(leadsBo);
		
		if (0 < status) {
			  request.setAttribute("successMessage","Leads Account Updated successfully!");
			    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listLeads");
				dispatcher.forward(request,response);
			  
    }else {
  	    request.setAttribute("errorMessage","Leads Account updation Failed!");
  	    
			RequestDispatcher dispatcher=request.getRequestDispatcher("/listLeads");
			dispatcher.forward(request,response);
    }

	}

}
