package com.triby.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.vo.Member;
import com.triby.review.model.service.ReviewService;
import com.triby.review.model.vo.Review;

/**
 * Servlet implementation class DeleteMemberReviewServlet
 */
@WebServlet("/deleteReview.me")
public class DeleteMemberReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int rNo=Integer.parseInt(request.getParameter("rNo"));
		if(session.getAttribute("loginUser")!=null) {
			int result=new ReviewService().deleteMemberReview(rNo);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
			
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
