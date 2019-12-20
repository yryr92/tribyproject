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
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice.ad")
public class AdminNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String selected = request.getParameter("selected");
	
		int listCount;
		if(selected == null) {
			
			listCount = new NoticeService().adminGetListCount();
		}else {
			listCount = new NoticeService().adminGetSelectedListCount(selected);
		}
	
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage; int startPage; int endPage;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		endPage = startPage+pageLimit-1;
		if(maxPage<endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<Notice> list = new ArrayList<>();
		if(selected == null) {
			
			 list = new NoticeService().selectNoticeListAdmin(pi);

		}else if(selected.equals("N")){
			list = new NoticeService().selectNoticeListSecretAdmin(pi,selected);

		}else {
			list = new NoticeService().selectNoticeListSelectedAdmin(pi,selected);

		}
		//if(!list.isEmpty()) {
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			if(selected == null) {
				request.getRequestDispatcher("/views/admin/notice/noticeListView.jsp").forward(request,response);
			}else {
				switch(selected) {
				case "공지" : request.getRequestDispatcher("/views/admin/notice/noticeNoticeListView.jsp").forward(request, response); break;
				case "이벤트" : request.getRequestDispatcher("/views/admin/notice/noticeEventListView.jsp").forward(request, response); break;
				case "호스트" : request.getRequestDispatcher("views/admin/notice/noticeHostListView.jsp").forward(request, response); break;
				case "N" : request.getRequestDispatcher("/views/admin/notice/noticeSecretListView.jsp").forward(request, response); break;
				}
			}
			
/*		}else {
			request.setAttribute("msg","조회할 리스트가 없습니다");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
		}*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
