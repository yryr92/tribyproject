package com.triby.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet("/login.me")
public class LoginMemberServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_pw");
		
		Member loginUser = new MemberService().loginMember(user_email, user_pw);
		
		HttpSession session = request.getSession();
		
		if(loginUser !=null) {
			
			if(loginUser.getEmail().equals("admin@triby.com")) {
				session.setAttribute("amdin", loginUser);
				session.setAttribute("adminMessage","관리자님 화이팅입니다!");
				request.getRequestDispatcher("/views/admin/adminMainView.jsp").forward(request, response);
			}else {	
			
				session.setAttribute("loginUser", loginUser);
				//response.sendRedirect(request.getContextPath());
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		}else {
			
			request.setAttribute("msg","로그인 실패" );
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
