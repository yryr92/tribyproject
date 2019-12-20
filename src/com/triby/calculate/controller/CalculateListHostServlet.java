package com.triby.calculate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.calculate.model.service.CalculateService;

/**
 * Servlet implementation class CalculateListHostServlet
 */
@WebServlet("/counth.ca")
public class CalculateListHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateListHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		int result = new CalculateService().getListCountH(hNo, status);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
