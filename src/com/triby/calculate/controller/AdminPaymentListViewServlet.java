package com.triby.calculate.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.payment.model.service.PaymentService;
import com.triby.payment.model.vo.Payment;

/**
 * Servlet implementation class CalculateListViewServlet
 */
@WebServlet("/calculate.ad")
public class AdminPaymentListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Payment> list = new PaymentService().adminSelectPaymentList();
		String past = new PaymentService().adminGetCustomMonth();
		request.setAttribute("list", list);
		request.setAttribute("past", past);
		request.getRequestDispatcher("/views/admin/calculate/paymentView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
