package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.review.model.service.ReviewService;
import com.triby.review.model.vo.ReviewHost;

/**
 * Servlet implementation class ManageReviewServlet
 */
@WebServlet("/manageRev.ho")
public class ManageReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		
		
		int listCount = new ReviewService().getListCountH(hNo);
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		
		}
		
		int pageLimit;		
		int boardLimit;		
		int maxPage;		
		int startPage;		
		int endPage;
		
		pageLimit = 5;
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		
		startPage = (page-1)/pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, page, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<ReviewHost> list = new ReviewService().selectListH(hNo, pi);
		
		int count = listCount;
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("views/host/manageRev.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
