package com.techymeet.crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet(urlPatterns = { "/verifyEmail", "/forgotPassword", "/changePassword" })
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String applicationContextPath = request.getContextPath();
		if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/forgotPassword")
				|| request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/changePassword")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/verify_user.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String applicationContextPath = request.getContextPath();//web/verifyEmail   
		if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/verifyEmail")) {

			String email = request.getParameter("emailAddress");
			boolean status = employeeService.verifyUser(email);
			if (status) {
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/change_password.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Sorry, User doesn't exist!");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/forgot_password.jsp");
				dispatcher.forward(request, response);
			}

		} else if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/changePassword")) {
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			String email = request.getParameter("emailAddress");
			if (password.equals(confirmPassword)) {
				

			} else {
				request.setAttribute("email", email);
				request.setAttribute("errorMessage", "Sorry, Password and confirm password Must be same!");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/change_password.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
