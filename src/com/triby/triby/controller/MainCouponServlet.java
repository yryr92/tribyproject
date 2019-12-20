package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.triby.coupon.model.vo.Coupon;
import com.triby.member.model.vo.Member;
import com.triby.triby.model.service.MainService;

/**
 * Servlet implementation class MainCouponServlet
 */
@WebServlet("/couponUse.ma")
public class MainCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();		// 회원 세션
		
		if(session.getAttribute("loginUser")!=null) {
			
			Member m=(Member)session.getAttribute("loginUser");
			
			ArrayList<Coupon> uC = new MainService().couponUse(m.getuNo());
			
			request.setAttribute("user", m);
			request.setAttribute("uC",uC);
			
			request.getRequestDispatcher("views/main/coupon_use.jsp").forward(request,response);
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
