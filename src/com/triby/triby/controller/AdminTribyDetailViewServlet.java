package com.triby.triby.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class AdminTribyDetailViewServlet
 */
@WebServlet("/tribyDetail.ad")
public class AdminTribyDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTribyDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		
		Triby triby = new TribyService().adminSelectTriby(tNo);
		
		request.setAttribute("pick", triby);
		request.getRequestDispatcher("/views/admin/triby/tribyDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
