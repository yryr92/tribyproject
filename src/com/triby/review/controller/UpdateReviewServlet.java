package com.triby.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.review.model.service.ReviewService;
import com.triby.review.model.vo.Review;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/updateReview.me")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int rNo=Integer.parseInt(request.getParameter("rNo"));
		int point=Integer.parseInt(request.getParameter("point"));
		String content=request.getParameter("content");
		if(session.getAttribute("loginUser")!=null) {
			Review r=new Review();
			r.setRvNo(rNo);
			r.setRvContent(content);
			r.setRvPoint(point);
			int result=new ReviewService().updateMemberReview(r);
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
