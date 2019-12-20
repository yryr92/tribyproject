package com.triby.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.notice.model.service.NoticeService;

/**
 * Servlet implementation class MainNoticeCountServlet
 */
@WebServlet("/mainNotice.count")
public class MainNoticeCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");
		if(category.equals("전체")) {
			int count=new NoticeService().mainNoticeCount();
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(count);
		}else {			
			int count=new NoticeService().mainNoticeCount(category);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(count);
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
