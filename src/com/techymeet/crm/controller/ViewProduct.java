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
import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.service.ProductService;
import com.techymeet.crm.service.ProductServiceImpl;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/viewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice=new ProductServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		 
		 if (null != session.getAttribute("loggedInUser")) {

			 String productId=request.getParameter("productId");
				int proId=Integer.valueOf(productId);
				 ProductBo productBo=productservice.viewProduct(proId);
				request.setAttribute("productBo", productBo);
				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/view_product.jsp");
				dispatch.forward(request, response);
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
