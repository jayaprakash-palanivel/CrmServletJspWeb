package com.techymeet.crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techymeet.crm.bo.LoginBo;
import com.techymeet.crm.service.LoginService;
import com.techymeet.crm.service.LoginServiceImpl;



/**
 * Servlet implementation class LoginEmployee
 */
@WebServlet("/login")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginservice=new LoginServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		
		LoginBo loginBo=new LoginBo();
		
		loginBo.setUserName(userName);
		loginBo.setPassword(password);
		
		LoginBo login = loginservice.LoginEmployee(loginBo);
		if(null !=login&&null!=login.getUserName()) {
			request.setAttribute("successMessage", "Login Success!");
			
			session.setAttribute("loggedInUser",login.getUserName());
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/home.jsp");
			dispatcher.forward(request,response);
		}else {
			request.setAttribute("errorMessage", "Login Failed!");
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/login.jsp");
			dispatcher.forward(request,response);
			//response.sendRedirect("/jsps/login.jsp");
		}

}
}