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
 * Servlet implementation class UpdateMemberPwdServlet
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("user_email");
		String newPwd = request.getParameter("newPwd");
		

	int result = new MemberService().updatePwd(userEmail, newPwd);

		if(result>0) {
			
			request.setAttribute("successPwd", "비밀번호 변경을 성공하였습니다.");
			System.out.println();
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패");
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
