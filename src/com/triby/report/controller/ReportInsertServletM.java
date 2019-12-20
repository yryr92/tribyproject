package com.triby.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.report.model.service.ReportService;
import com.triby.report.model.vo.Report;

/**
 * Servlet implementation class ReportInsertServletM
 */
@WebServlet("/insertbym.rep")
public class ReportInsertServletM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertServletM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uNo = Integer.parseInt(request.getParameter("uNo"));
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		String report = request.getParameter("report");
		String etc = request.getParameter("etc");
		
		Report re = new Report();
		re.setrDetail(report + etc);
		re.setrReporter(uNo);
		re.setrTarget(hNo);
		
		int result = new ReportService().insertReport(re, 1);
		
		if(result > 0) {
			request.setAttribute("msg", "신고가 성공적으로 완료되었습니다.");
		} else {
			request.setAttribute("msg", "신고 실패");
		}
		
		request.setAttribute("uNo", uNo);
		request.setAttribute("hNo", hNo);
		request.getRequestDispatcher("views/common/reportMember.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
