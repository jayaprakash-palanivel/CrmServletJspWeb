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
 * Servlet implementation class EditProduct
 */
@WebServlet("/updateProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice=new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
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
			
			String productId = request.getParameter("productId");
			int proId = Integer.valueOf(productId);
			
			ProductBo productbo = productservice.viewProduct(proId);
			
			if (null != productbo) {
				request.setAttribute("updateProduct", productbo);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/edit_product.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Edit failed");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listProduct");
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("ErrorMessage", "EditProcessFailed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId=request.getParameter("productId");
		String productName=request.getParameter("productName");
		String productSpecification=request.getParameter("productSpecification");
		String minimumStocks=request.getParameter("minimumStocks");
		String maximumStocks=request.getParameter("maximumStocks");
		String availableStocks=request.getParameter("availableStocks");
		String price=request.getParameter("price");
		
		int proId=Integer.valueOf(productId);
		int value=Integer.valueOf(price);
		ProductBo productBo=new ProductBo();
		
		productBo.setProductId(proId);
		productBo.setProductName(productName);
		productBo.setProductSpecification(productSpecification);
		productBo.setMinimumStocks(minimumStocks);
		productBo.setMaximumStocks(maximumStocks);
		productBo.setAvailableStocks(availableStocks);
		productBo.setPrice(value);
		
		PrintWriter out=response.getWriter();
		
		int status=productservice.editProduct(productBo);
		
		if (0 < status) {
			  request.setAttribute("successMessage","Product Account Updated successfully!");
			    
				RequestDispatcher dispatcher=request.getRequestDispatcher("/listProduct");
				dispatcher.forward(request,response);
			  
    }else {
  	    request.setAttribute("errorMessage","Product Account updation Failed!");
  	    
			RequestDispatcher dispatcher=request.getRequestDispatcher("/listProduct");
			dispatcher.forward(request,response);
    }

	}

}
