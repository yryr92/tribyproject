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
import com.triby.triby.model.vo.MainDetailRight;
import com.triby.triby.model.vo.MainDetailTriby;
import com.triby.triby.model.vo.MainHostDetail;
import com.triby.triby.model.vo.MainReviewDetail;
import com.triby.triby.model.vo.ThumbnailTriby;

/**
 * Servlet implementation class MainDetailServlet
 */
@WebServlet("/detail.ma")
public class MainDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		
		ArrayList<MainDetailTriby> dt = new MainService().detailTriby(tNo);		// 트리비 정보
		ArrayList<MainHostDetail> dh = new MainService().detailHost(tNo);		// 호스트 정보
		ArrayList<MainDetailRight> dr = new MainService().detailRight(tNo);		// 옵션 정보
		ArrayList<ThumbnailTriby> ot = new MainService().otherTriby();			// 이런 트리비는 어떠세요?
		ArrayList<MainReviewDetail> dv = new MainService().detailReview(tNo);	// 리뷰 정보

		request.setAttribute("tNo", tNo);
		request.setAttribute("dt",dt);
		request.setAttribute("dh",dh);
		request.setAttribute("dv",dv);
		request.setAttribute("dr",dr);
		request.setAttribute("ot",ot);
		
		
		
		request.getRequestDispatcher("views/main/detailTriby.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
