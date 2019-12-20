package com.triby.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.notice.model.service.NoticeService;
import com.triby.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailListViewServlet
 */
@WebServlet("/noticeDetail.ad")
public class AdminNoticeDetailListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDetailListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int nNo = Integer.parseInt(request.getParameter("nNo"));
	
		Notice notice = new NoticeService().selectNoticeAdmin(nNo);
		
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/views/admin/notice/noticeDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "조회할 리스트가 없습니다");
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
