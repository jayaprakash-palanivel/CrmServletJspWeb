package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService=new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		String employeeId=request.getParameter("employeeId");
		int empId=Integer.valueOf(employeeId);
		 boolean status = employeeService.DeleteEmployee( empId);
		 
		 	if(status) {
		 		
		 		 request.setAttribute("successMessage","Employee Account Deleted successfully!");
				    
					RequestDispatcher dispatcher=request.getRequestDispatcher("/listEmployee");
					dispatcher.forward(request,response);
		 	}else {
		 		request.setAttribute("errorMessage","Employee Account Deletion Failed!");
	      	    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listEmployee");
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
