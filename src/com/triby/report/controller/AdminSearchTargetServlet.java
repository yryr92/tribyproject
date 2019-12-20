package com.triby.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.report.model.service.ReportService;
import com.triby.report.model.vo.Report;

/**
 * Servlet implementation class AdminSearchTargetServlet
 */
@WebServlet("/searchTarget.ad")
public class AdminSearchTargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchTargetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int target = Integer.parseInt(request.getParameter("target"));
		String targetStr = request.getParameter("target");
		//ArrayList<Report> targetList = new ReportService().adminSelectTargetList(target);
		ArrayList<Report> targetList = new ReportService().adminSelectTargetCheckList(targetStr);
		if(!targetList.isEmpty()) {
			request.setAttribute("list", targetList);
			request.setAttribute("target",target);
			request.getRequestDispatcher("/views/admin/report/reportTargetList.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "�빐�떦�쉶�썝�뿉 ���븳 �젙蹂닿� �뾾�뒿�땲�떎");
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
