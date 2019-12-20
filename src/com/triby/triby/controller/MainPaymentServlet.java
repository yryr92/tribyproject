package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.coupon.model.vo.Coupon;
import com.triby.member.model.vo.Member;
import com.triby.triby.model.service.MainService;
import com.triby.triby.model.vo.ThumbnailTriby;

/**
 * Servlet implementation class MainPaymentServlet
 */
@WebServlet("/payment.ma")
public class MainPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {	// 로그인
			
			// 썸네일 호출 / 트라비번호, 트리비이름, 가격, 썸네일
			int tNo = Integer.parseInt(request.getParameter("tNo"));			// 트리비 번호
			// 옵션 번호
			int oNo = Integer.parseInt(request.getParameter("oNo"));			// 옵션 번호
			// 트리비 하는 날짜
			String tDay = request.getParameter("tDay");							// 트리비 시작날짜+시간
			// 사람 수
			int person = Integer.parseInt(request.getParameter("person"));		// 사람 수
			// 가격
			int tPayment = Integer.parseInt(request.getParameter("tPayment"));	// 가격
			
			Member user = (Member)session.getAttribute("loginUser");		// 회원 세션
			
			ArrayList<Coupon> uC = new MainService().couponUse(user.getuNo());	// 사용자 쿠폰 정보들 담긴 리스트
			ArrayList<ThumbnailTriby> pt = new MainService().paymentTriby(tNo);
			
			request.setAttribute("user", user);
			request.setAttribute("uC",uC);
			request.setAttribute("tNo",tNo);
			request.setAttribute("oNo",oNo);
			request.setAttribute("tDay",tDay);
			request.setAttribute("person",person);
			request.setAttribute("tPayment",tPayment);
			request.setAttribute("pt",pt);
			
			request.getRequestDispatcher("views/main/payment.jsp").forward(request, response);
			
		}else {	// 비 로그인
			request.setAttribute("msg","로그인 후 이용해주세요!");
			request.getRequestDispatcher("/views/common/loginPlz.jsp").forward(request, response);
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
