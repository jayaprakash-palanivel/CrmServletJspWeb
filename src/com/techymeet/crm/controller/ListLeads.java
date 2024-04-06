package com.techymeet.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.service.LeadsService;
import com.techymeet.crm.service.LeadsServiceImpl;

/**
 * Servlet implementation class ListLeads
 */
@WebServlet("/listLeads")
public class ListLeads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LeadsService leadsservice=new LeadsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLeads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		if(null!=session.getAttribute("loggedInUser")){
			List<LeadsBo> leadsList=leadsservice.listLeads();
			
			if(null !=leadsList && 0<leadsList.size()) {
				request.setAttribute("leadsList", leadsList);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_leads.jsp");
				dispatch.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Record Found!");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_leads.jsp");
				dispatch.forward(request, response);
			}

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
