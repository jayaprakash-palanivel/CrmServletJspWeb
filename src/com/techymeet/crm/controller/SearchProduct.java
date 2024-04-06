package com.techymeet.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.service.ProductService;
import com.techymeet.crm.service.ProductServiceImpl;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService productService=new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductBo productBo=new ProductBo();
		
		if(!request.getParameter("productName").isEmpty()) {
			
			if (null != request.getParameter("productName") && !request.getParameter("productName").isEmpty()) {
				String productName = request.getParameter("productName");
				productBo.setProductName(productName);
			}
			
			List<ProductBo> productList=productService.searchProduct(productBo);
			
			if (null != productList && 0 < productList.size()) {
				request.setAttribute("productList", productList);
				request.setAttribute("search", "search");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_product.jsp");
				dispatch.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Record Found!");
				request.setAttribute("search", "search");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_product.jsp");
				dispatch.forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Please enter something to search!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/listProduct");
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
