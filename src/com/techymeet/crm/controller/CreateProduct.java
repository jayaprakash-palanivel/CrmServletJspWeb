package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CreateProduct
 */
@WebServlet("/createProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProduct() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/create_product.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// another way to convert string into integer
		// int product=Integer.valueOf(request.getParameter("productId"));

		String productName = request.getParameter("productName");
		String productSpecification = request.getParameter("productSpecification");
		String minimumStocks = request.getParameter("minimumStocks");
		String maximumStocks = request.getParameter("maximumStocks");
		String availableStocks = request.getParameter("availableStocks");
		String price = request.getParameter("price");

		int value = Integer.valueOf(price);

		ProductBo productBo = new ProductBo();

		productBo.setProductName(productName);
		productBo.setProductSpecification(productSpecification);
		productBo.setMinimumStocks(minimumStocks);
		productBo.setMaximumStocks(maximumStocks);
		productBo.setAvailableStocks(availableStocks);
		productBo.setPrice(value);

		int status = productService.createProduct(productBo);
		if (0 < status) {
			request.setAttribute("successMessage", "Product created successfully!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/listProduct");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Product creation Failed!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/create_product.jsp");
			dispatcher.forward(request, response);
		}

	}

}
