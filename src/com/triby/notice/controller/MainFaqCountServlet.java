package com.triby.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.triby.faq.model.vo.Faq;
import com.triby.member.model.service.MemberService;
import com.triby.notice.model.service.NoticeService;

/**
 * Servlet implementation class MainFaqCountServlet
 */
@WebServlet("/loadMainFaq.count")
public class MainFaqCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFaqCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("key");
		if(key.equals("전체")) {
			int listCount=new NoticeService().loadMainFaqCount();
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(listCount);
		}else {
			int listCount=new NoticeService().loadMainFaqCount(key);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(listCount);
			
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
