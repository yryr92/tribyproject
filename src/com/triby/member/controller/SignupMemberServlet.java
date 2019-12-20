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
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/signup.me")
public class SignupMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userEmail = request.getParameter("email");
		String userPw = request.getParameter("pw");
		String userName = request.getParameter("name");
		String userGender = request.getParameter("gender");
		String userPhone = request.getParameter("phone");
		
		String[] userCategorys = request.getParameterValues("category");
		
		
		String userCategory = "";
		if(userCategorys != null) {
			userCategory = String.join(",", userCategorys);
		}
	
	Member mem = new Member(userEmail, userPw, userName, userGender, userPhone , userCategory);
	
		int result = new MemberService().signupMember(mem);
		
		if(result>0) { // 성공시
			HttpSession session = request.getSession();
			
			session.setAttribute("joinSuccessMsg", "회원가입이 완료되었습니다!");
//			session.setAttribute("loginUser", mem);
//			response.sendRedirect(request.getContextPath());			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {// 실패시
			request.setAttribute("msg", "회원 가입 실패");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
