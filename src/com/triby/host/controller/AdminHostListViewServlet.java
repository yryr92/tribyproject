package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;
import com.triby.common.PageInfo;

/**
 * Servlet implementation class AdminHostListViewServlet
 */
@WebServlet("/host.ad")
public class AdminHostListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHostListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status = request.getParameter("status");
		
		int listCount = new HostService().adminGetListCount();
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageLimit= 10;
		int boardLimit=10;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage + pageLimit -1;
		if(maxPage <endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		ArrayList<Host> list = new ArrayList<>();
		if(status == null) {
			
			list = new HostService().selectHostAdmin(pi);
			if(!list.isEmpty()) {
				request.setAttribute("pi", pi);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/admin/memberHost/hostView.jsp").forward(request, response);
			}else {
				request.setAttribute("msg","해당 리스트가 없습니다");
				request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
			}
		}else if(status != null && status.equals("Y")){
			
			list = new HostService().selectHostAdminStatus(pi);
			if(!list.isEmpty()) {
				request.setAttribute("pi", pi);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/admin/memberHost/hostOutView.jsp").forward(request, response);
		}else {
				request.setAttribute("msg","해당 리스트가 없습니다");
				request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
			}
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
