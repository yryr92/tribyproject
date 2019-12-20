package com.triby.blackList.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.blackList.model.service.BlackListService;
import com.triby.blackList.model.vo.BlackList;

/**
 * Servlet implementation class BlackListInsertServlet
 */
@WebServlet("/insertBlacklist.ad")
public class AdminBlacklistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlacklistInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int target = Integer.parseInt(request.getParameter("target"));
		
		int check = new BlackListService().adminSelectTarget(target);
		
		if(check ==0) {
			ArrayList<BlackList> list = new BlackListService().adminInsertBlacklist(target);
			
			if(!list.isEmpty()) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/admin/blacklist/blacklistView.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "등록할 수 없습니다");
				request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
			}
			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("black", "이미 등록된 대상자 입니다");
		
			response.sendRedirect("report.ad");
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
