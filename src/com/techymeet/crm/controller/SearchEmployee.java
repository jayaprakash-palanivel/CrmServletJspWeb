package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class SerachEmployee
 */
@WebServlet("/searchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeBo employee = new EmployeeBo();
        if(!request.getParameter("firstName").isEmpty() || !request.getParameter("email").isEmpty() || !request.getParameter("mobileNumber").isEmpty()) {
		
			if (null != request.getParameter("firstName") && !request.getParameter("firstName").isEmpty()) {
				String firstName = request.getParameter("firstName");
				employee.setFirstName(firstName);
			}
			if (null != request.getParameter("email") && !request.getParameter("email").isEmpty()) {
				String email = request.getParameter("email");
				employee.setEmailAddress(email);
			}

			if (null != request.getParameter("mobileNumber") && !request.getParameter("mobileNumber").isEmpty()) {
				long mobileNumber = Long.valueOf(request.getParameter("mobileNumber"));
				employee.setMobileNumber(mobileNumber);
			}

			List<EmployeeBo> employeeList = employeeService.searchEmployee(employee);
			if (null != employeeList && 0 < employeeList.size()) {
				request.setAttribute("employeeList", employeeList);
				request.setAttribute("search", "search");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_employee.jsp");
				dispatch.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Record Found!");
				request.setAttribute("search", "search");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_employee.jsp");
				dispatch.forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Please enter something to search!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployee");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
