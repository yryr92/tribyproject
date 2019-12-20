package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.triby.host.model.service.HostService;
import com.triby.review.model.vo.MyReview;
import com.triby.triby.model.vo.ThumbnailTriby;

/**
 * Servlet implementation class LoadHostTribyListServlet
 */
@WebServlet("/loadHostDetailContent.ma")
public class LoadHostTribyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadHostTribyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String str=request.getParameter("str");
		int page=Integer.parseInt(request.getParameter("page"));
		int hNo=Integer.parseInt(request.getParameter("hNo"));
		if(str.equals("트리비")) {
			ArrayList<ThumbnailTriby> list=new HostService().loadHostTribyList(hNo,page);
			response.setContentType("application/json; charset=UTF-8");
			Gson gson=new Gson();
			gson.toJson(list, response.getWriter());			
		}else {
			ArrayList<MyReview> list=new HostService().loadHostReviewList(hNo,page);
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
