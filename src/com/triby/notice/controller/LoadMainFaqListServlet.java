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
import com.triby.notice.model.service.NoticeService;
import com.triby.notice.model.vo.Notice;

/**
 * Servlet implementation class LoadMainFaqListServlet
 */
@WebServlet("/loadMainFaq.fq")
public class LoadMainFaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMainFaqListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("key");
		int page=Integer.parseInt(request.getParameter("page"));
		if(key.equals("전체")) {
			ArrayList<Faq> list=new NoticeService().loadMainFaqList(page);
			response.setContentType("application/json; charset=UTF-8");
			Gson gson=new Gson();
			gson.toJson(list, response.getWriter());
		}else {
			ArrayList<Faq> list=new NoticeService().loadMainFaqList(key,page);
			response.setContentType("application/json; charset=UTF-8");
			Gson gson=new Gson();
			gson.toJson(list, response.getWriter());
			
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
