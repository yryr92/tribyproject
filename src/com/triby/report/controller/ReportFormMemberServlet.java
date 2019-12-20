package com.triby.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.vo.Member;

/**
 * Servlet implementation class ReportFormMemberServlet
 */
@WebServlet("/insertM.rep")
public class ReportFormMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportFormMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {	// 로그인
			
			Member user = (Member)session.getAttribute("loginUser");
			
			int uNo = user.getuNo();
			int hNo = Integer.parseInt(request.getParameter("hNo"));
			//System.out.println(uNo);
		
			request.setAttribute("msg", "null");
			request.setAttribute("uNo", uNo);
			request.setAttribute("hNo", hNo);
			request.getRequestDispatcher("views/common/reportMember.jsp").forward(request, response);
			
		}else {	// 비 로그인
			request.setAttribute("msg","로그인 후 이용해주세요!");
			request.getRequestDispatcher("/views/common/loginPlz.jsp").forward(request, response);
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
