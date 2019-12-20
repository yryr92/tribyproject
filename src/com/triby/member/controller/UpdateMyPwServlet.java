package com.triby.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMyPwServlet
 */
@WebServlet("/UpdateMyPwServlet")
public class UpdateMyPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pw=request.getParameter("pw");
		if(session.getAttribute("loginUser")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			int result=new MemberService().updateMyPw(m,pw);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
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
