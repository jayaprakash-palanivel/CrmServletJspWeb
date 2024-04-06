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
import javax.servlet.http.HttpSession;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ListEmployee
 */
@WebServlet("/listEmployee")
public class ListEmployee extends HttpServlet {
	EmployeeService employeeService = new EmployeeServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (null != request.getAttribute("successMessage")) {
			request.setAttribute("successMessage", request.getAttribute("successMessage"));
		}

		if (null != request.getAttribute("errorMessage")) {
			request.setAttribute("errorMessage", request.getAttribute("errorMessage"));
		}
		
		
		if (null != session.getAttribute("loggedInUser")) {
			List<EmployeeBo> employeeList = employeeService.listEmployee();

			if (null != employeeList && 0 < employeeList.size()) {
				request.setAttribute("employeeList", employeeList);

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_employee.jsp");
				dispatch.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Record Found!");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_employee.jsp");
				dispatch.forward(request, response);
			}

		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/login.jsp");
			dispatch.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
