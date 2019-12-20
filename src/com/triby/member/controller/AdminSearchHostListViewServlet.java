package com.triby.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class AdminSearchHostListViewServlet
 */
@WebServlet("/searchHost.ad")
public class AdminSearchHostListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchHostListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("selectSearch");
		String input = request.getParameter("searchHostInput");
		ArrayList<Host> list = new ArrayList<>();
		if(search.equals("selectHostNo")) {
			list= new HostService().adminSearchHostNoList(input);
		}else {
			list = new HostService().adminSearchHostNameList(input);
		}
		//if(!list.isEmpty()) {
			request.setAttribute("list",list);
			request.getRequestDispatcher("/views/admin/memberHost/hostSearchView.jsp").forward(request, response);
/*		}else {
			request.setAttribute("msg", "해당회원이 없습니다");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request,response);
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
