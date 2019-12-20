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
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/updateNotice.ad")
public class AdminNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		request.setCharacterEncoding("utf-8");
		
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		Notice notice = new Notice();
		notice.setnNo(nNo);
		notice.setnTitle(request.getParameter("nTitle"));
		notice.setnCategory(request.getParameter("nCategory"));
		notice.setnStatus(request.getParameter("nStatus"));
		notice.setnContent(request.getParameter("nContent"));
		
		System.out.println("Notice" +notice.toString());
		Notice newNotice = new NoticeService().updateNotice(notice);
		if(newNotice != null) {
			request.setAttribute("notice", newNotice);
			request.getRequestDispatcher("/views/admin/notice/noticeDetailView.jsp").forward(request, response);
			System.out.println("newNotice"+newNotice.toString());
		}else {
			request.setAttribute("msg", "다시 수정해 주세요");
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
