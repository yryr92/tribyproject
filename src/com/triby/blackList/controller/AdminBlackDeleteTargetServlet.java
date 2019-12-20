package com.triby.blackList.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.blackList.model.service.BlackListService;

/**
 * Servlet implementation class BlackDeleteTargetServlet
 */
@WebServlet("/deleteTarget.ad")
public class AdminBlackDeleteTargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlackDeleteTargetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int target = Integer.parseInt(request.getParameter("target"));
		
		int result = new BlackListService().adminDeleteBlacklist(target);
		
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("target", "탈퇴 처리 하였습니다");
			response.sendRedirect("blacklist.ad");
		}else {
			request.setAttribute("msg","리스트를 삭제하지 못했습니다");
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
