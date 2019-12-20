package com.triby.payment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.payment.model.service.PaymentService;
import com.triby.payment.model.vo.PaymentforHost;

/**
 * Servlet implementation class PaymentSelectListHServlet
 */
@WebServlet("/selecth.pa")
public class PaymentSelectListHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSelectListHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		
		ArrayList<PaymentforHost> list = new PaymentService().selectListH(oNo);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/host/attendanceMember.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
