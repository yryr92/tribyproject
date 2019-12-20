package com.triby.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.service.MemberService;

/**
 * Servlet implementation class TribyCancelServlet
 */
@WebServlet("/tribyCancel.me")
public class TribyCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TribyCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int pNo=Integer.parseInt(request.getParameter("pNo"));
		if(session.getAttribute("loginUser")!=null) {
			int result=new MemberService().tribyCancel(pNo);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(0);
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
