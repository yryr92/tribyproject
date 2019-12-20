package com.triby.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.notice.model.service.NoticeService;
import com.triby.notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeSearchListViewServlet
 */
@WebServlet("/searchNotice.ad")
public class AdminNoticeSearchListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeSearchListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("searchNoticeTitle");
		int listCount = new NoticeService().adminGetSearchListCount(title);
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit-1;
		if(maxPage<endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);

		ArrayList<Notice> list = new NoticeService().adminSearchNoticeList(pi, title);
		
		if(!list.isEmpty()) {
			request.setAttribute("pi", pi);
			request.setAttribute("list",list);
			request.setAttribute("searchNoticeTitle", title);
			request.getRequestDispatcher("/views/admin/notice/noticeSearchListView.jsp").forward(request,response);
		}else {
			request.setAttribute("msg", "조회하실 내용이 없습니다");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
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
