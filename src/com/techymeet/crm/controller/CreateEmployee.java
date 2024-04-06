package com.techymeet.crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class createEmployee
 */
@WebServlet("/createEmployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * Default constructor.
	 */
	public CreateEmployee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsps/create_employee.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String mobileNumber = request.getParameter("mobileNumber");
		String dateofBirth = request.getParameter("dateofBirth");
		
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");

		EmployeeBo employeeBo = new EmployeeBo();
		
       
		employeeBo.setFirstName(firstName);
		employeeBo.setLastName(lastName);
		employeeBo.setEmailAddress(email);
		employeeBo.setPassword(password);
		employeeBo.setMobileNumber(Long.valueOf(mobileNumber));
		employeeBo.setDateofBirth(dateofBirth);
		employeeBo.setAddress(address);
		employeeBo.setCity(city);
		employeeBo.setCountry(country);

		int status = employeeService.createEmployee(employeeBo);
		if (0 < status) {
			request.setAttribute("successMessage", "Employee Account created successfully!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployee");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Employee Account creation Failed!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/create_employee.jsp");
			dispatcher.forward(request, response);
		}

	}

}
