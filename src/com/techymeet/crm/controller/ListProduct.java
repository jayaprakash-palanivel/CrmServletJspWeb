package com.techymeet.crm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ListProduct
 */
@WebServlet("/listProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice = new ProductServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProduct() {
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
			List<ProductBo> productList = productservice.listProduct();

			if (null != productList && 0 < productList.size()) {
				request.setAttribute("productList", productList);

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_product.jsp");
				dispatch.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "No Record Found!");

				RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/list_product.jsp");
				dispatch.forward(request, response);
			}

		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/login.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
