package com.triby.blackList.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.blackList.model.service.BlackListService;
import com.triby.blackList.model.vo.BlackList;

/**
 * Servlet implementation class BlacklistViewServlet
 */
@WebServlet("/blacklist.ad")
public class AdminBlacklistViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlacklistViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BlackList> list = new BlackListService().adminSelectBlackList();
		//if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/admin/blacklist/blacklistView.jsp").forward(request,response);
/*		}else {
			request.setAttribute("msg", "조회할 내용이 없습니다");
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
