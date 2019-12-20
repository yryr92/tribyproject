package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class AdminTribyViewServlet
 */
@WebServlet("/triby.ad")
public class AdminTribyListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTribyListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int listCount = new TribyService().adminGetListCount();
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
		
		ArrayList<Triby> list = new TribyService().adminSelectDisTribyList(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("/views/admin/triby/tribyListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
