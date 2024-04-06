package com.techymeet.crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainController
 */


//-------> / url will call first when we run the project.

@WebServlet(urlPatterns = {"/","/home","/logout"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationContextPath = request.getContextPath();
		System.out.println(applicationContextPath);
		System.out.println(request.getRequestURI());
		
		if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/")) {
			 RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/login.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/home")) {
			 RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/home.jsp");
			dispatcher.forward(request, response);
		}else if (request.getRequestURI().equalsIgnoreCase(applicationContextPath + "/logout")) {
			 HttpSession session=request.getSession();
			 session.invalidate();
			 
			 RequestDispatcher dispatcher=request.getRequestDispatcher("/jsps/login.jsp");
			 dispatcher.forward(request, response);
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
