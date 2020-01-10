package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class MyTribyServlet
 */
@WebServlet("/myTriby.ho")
public class MyTribyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTribyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		int listCount = new TribyService().getListCountH(hNo, status);
		
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
		boardLimit = 9;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (page-1)/pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, page, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Triby> tList = new TribyService().selectListH(hNo, status, pi);
		ArrayList<Image> iList = new TribyService().selectImgListH(hNo, status, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("tList", tList);
		request.setAttribute("iList", iList);
		request.setAttribute("status", status);
		//response.sendRedirect("/views/host/myTriby.jsp");
		
		request.getRequestDispatcher("views/host/myTriby.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
