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
import com.techymeet.crm.service.EmployeeService;
import com.techymeet.crm.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/editEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmployee() {
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
			String employeeId = request.getParameter("employeeId");
			int empId = Integer.valueOf(employeeId);
			
			EmployeeBo employeeBo = employeeService.viewEmployee(empId);
			
			if (null != employeeBo) {
				request.setAttribute("editEmployee", employeeBo);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/edit_employee.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Edit failed");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployee");
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("ErrorMessage", "EditProcessFailed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		int empId = Integer.valueOf(employeeId);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String mobileNumber = request.getParameter("mobileNumber");
		long mobileNo=Long.parseLong(mobileNumber);
		String dateofBirth = request.getParameter("dateofBirth");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		EmployeeBo employeeBo = new EmployeeBo();

		employeeBo.setEmployeeId(empId);
		employeeBo.setFirstName(firstName);
		employeeBo.setLastName(lastName);
		employeeBo.setEmailAddress(emailAddress);
		employeeBo.setPassword(password);
		employeeBo.setMobileNumber(Long.valueOf(mobileNumber));
		employeeBo.setDateofBirth(dateofBirth);
		employeeBo.setAddress(address);
		employeeBo.setCity(city);
		employeeBo.setCountry(country);

		int status = employeeService.updateEmployee(employeeBo);

		
		if (0 < status) {
			  request.setAttribute("successMessage","Employee Account Updated successfully!");
			    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listEmployee");
				dispatcher.forward(request,response);
			  
      }else {
    	    request.setAttribute("errorMessage","Employee Account updation Failed!");
    	    
			RequestDispatcher dispatcher=request.getRequestDispatcher("/listEmployee");
			dispatcher.forward(request,response);
      }

	}

}
