package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.qnaHost.model.service.QnAService;
import com.triby.qnaHost.model.vo.QnA;
import com.triby.triby.model.service.TribyService;

/**
 * Servlet implementation class ManageQnaServlet
 */
@WebServlet("/manageQna.ho")
public class ManageQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		
		int listCount = new QnAService().getListCountH(hNo, status);
		
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
		
		
		ArrayList<QnA> list = new QnAService().selectListH(hNo, status, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("status", status);
		request.getRequestDispatcher("views/host/manageQna.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
