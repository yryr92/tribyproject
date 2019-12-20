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
import com.triby.member.model.vo.Member;
import com.triby.payment.model.vo.Payment;
import com.triby.triby.model.service.MainService;

/**
 * Servlet implementation class MainPayCompleteServlet
 */
@WebServlet("/payComplete.ma")
public class MainPayCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPayCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oNo = Integer.parseInt(request.getParameter("oNo"));			// 옵션 번호
		int tPayment = Integer.parseInt(request.getParameter("tPayment"));	// 최종금액
		String payInfo = request.getParameter("payInfo");					// 결제정보
		int dic = Integer.parseInt(request.getParameter("dic"));			// 할인액
		int person = Integer.parseInt(request.getParameter("person"));		// 사람수
		int cNo = Integer.parseInt(request.getParameter("cNo"));			// 쿠폰번호
		
		// 세션 정보 - 회원 정보
		HttpSession session = request.getSession();
		Member user = (Member)session.getAttribute("loginUser");
		int uNo = user.getuNo();											// 회원 번호
		
		Payment p = new Payment();
		p.setUno(uNo);
		p.settONo(oNo);
		p.setpFinal(tPayment);
		p.setpInfo(payInfo);
		p.setpDis(dic);
		
		int result = new MainService().payInfo(p);			// 여기까지가 결제 정보 저장
		int result2 = new MainService().payCoupon(cNo);		// 사용한 쿠폰 완료 처리
		int result3 = new MainService().payPerson(person, oNo);	// option 현재원 증가
		
		Gson gson = new Gson();
		gson.toJson(result,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
