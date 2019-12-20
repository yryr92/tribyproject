package com.triby.triby.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.triby.model.service.TribyService;

/**
 * Servlet implementation class DeleteTribyServlet
 */
@WebServlet("/delete.tr")
public class DeleteTribyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTribyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		
		int result = new TribyService().deleteTriby(tNo);
		
	//	int status = 0;
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		request.setAttribute("hNo", hNo);
		request.setAttribute("status", status);
		request.getRequestDispatcher("myTriby.ho").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
