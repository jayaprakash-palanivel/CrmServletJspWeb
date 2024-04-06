package com.techymeet.crm.controller;

import java.io.IOException;

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
 * Servlet implementation class viewEmployee
 */
@WebServlet("/viewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (null != session.getAttribute("loggedInUser")) {

			int employeeId = Integer.parseInt(request.getParameter("employeeId"));

			EmployeeBo employeeBo = employeeService.viewEmployee(employeeId);
			request.setAttribute("employeeBo", employeeBo);
			RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/view_employee.jsp");
			dispatch.forward(request, response);
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

		doGet(request, response);

	}

}
