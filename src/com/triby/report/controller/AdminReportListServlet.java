package com.triby.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.report.model.service.ReportService;
import com.triby.report.model.vo.Report;

/**
 * Servlet implementation class ReportListServlet
 */
@WebServlet("/report.ad")
public class AdminReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = new ReportService().adminGetListCount();
		int currentPage = 1;
		if( request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit-1;
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);

		ArrayList<Report> reportList = new ReportService().adminSelectReportList(pi);
			
		//if(!reportList.isEmpty()) {
			request.setAttribute("black", request.getAttribute("black"));
			request.setAttribute("list", reportList);
			request.setAttribute("pi",pi);
			request.getRequestDispatcher("/views/admin/report/reportListView.jsp").forward(request, response);
/*		}else {
			request.setAttribute("msg", "조회할 리스트가 없습니다");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
