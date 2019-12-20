package com.triby.triby.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.triby.model.service.TribyService;

/**
 * Servlet implementation class AdminTribyUpdateApprovalServlet
 */
@WebServlet("/tribyApprove.ad")
public class AdminTribyUpdateApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTribyUpdateApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		int result = new TribyService().adminUpdateApproval(tNo);
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("appMsg", "트리비승인이 완료되었습니다");
			response.sendRedirect(request.getContextPath() + "/triby.ad");
		}else {
			request.setAttribute("msg", "업데이트실패");
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
