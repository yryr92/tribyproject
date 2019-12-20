package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;

/**
 * Servlet implementation class LoadHostContentCountServlet
 */
@WebServlet("/loadHostDetail.count")
public class LoadHostContentCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadHostContentCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("category");
		int hNo=Integer.parseInt(request.getParameter("hNo"));
		int result=0;
		if(str.equals("트리비")) {
			result=new HostService().loadHostTribyListCount(hNo);
		}else {
			result=new HostService().loadHostReviewListCount(hNo);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
