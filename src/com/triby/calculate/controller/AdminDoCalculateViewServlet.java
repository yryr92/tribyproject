package com.triby.calculate.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.calculate.model.service.CalculateService;
import com.triby.payment.model.service.PaymentService;
import com.triby.payment.model.vo.Payment;

/**
 * Servlet implementation class AdminDoCalculateViewServlet
 */
@WebServlet("/doCalculate.ad")
public class AdminDoCalculateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDoCalculateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Payment> list = new PaymentService().adminSelectSumList();
		String past = new PaymentService().adminGetCustomMonth();
/*		if(!list.isEmpty()) {
			new CalculateService().adminInsertNCalculate(list);
		}*/
		request.setAttribute("list", list);
		request.setAttribute("past", past);
		request.getRequestDispatcher("/views/admin/calculate/doCalculate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
