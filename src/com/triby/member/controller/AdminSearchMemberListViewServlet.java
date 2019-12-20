package com.triby.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;

/**
 * Servlet implementation class AdminSearchMemberListViewServlet
 */
@WebServlet("/searchMem.ad")
public class AdminSearchMemberListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchMemberListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("selectSearch");
		String input = request.getParameter("searchMemInput");
		ArrayList<Member> list = new ArrayList<>();
		if(search.equals("selectUserId")) {
			list = new MemberService().adminSearchUserNoList(input);
		}else {
			list = new MemberService().adminSearchUserNameList(input);
		}
		
		//if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/admin/memberHost/memberSearchView.jsp").forward(request, response);
/*		}else {
			request.setAttribute("msg", "없는 회원입니다");
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
