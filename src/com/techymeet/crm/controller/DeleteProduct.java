package com.techymeet.crm.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.service.ProductService;
import com.techymeet.crm.service.ProductServiceImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice=new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
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
		String productId=request.getParameter("productId");
		int proId=Integer.valueOf(productId);
		boolean status=productservice.deleteProduct(proId);
		 
		if(status) {
	 		
	 		 request.setAttribute("successMessage","product Account Deleted successfully!");
			    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listProduct");
				dispatcher.forward(request,response);
	 	}else {
	 		request.setAttribute("errorMessage","product Account Deletion Failed!");
    	    
			RequestDispatcher dispatcher=request.getRequestDispatcher("/listProduct");
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
