package com.triby.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;
import com.triby.member.model.vo.MyTriby;

/**
 * Servlet implementation class WriteAreviewFormServlet
 */
@WebServlet("/writeAreivewForm.me")
public class WriteAreviewFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteAreviewFormServlet() {
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
			Member m=(Member)session.getAttribute("loginUser");
			MyTriby triby=new MemberService().selectReviewTarget(m,pNo);
			response.setContentType("application/json; charset=UTF-8");
			Gson gson=new Gson();
			gson.toJson(triby, response.getWriter());
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
