package com.triby.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.member.model.service.MemberService;

/**
 * Servlet implementation class IdCheckServelt
 */
@WebServlet("/emailCheck.me")
public class emailCheckServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emailCheckServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("email");
		
		int result = new MemberService().emailCheck(userEmail);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) { // 이메일 값이 중복된다. --> 사용불가능

			out.print("fail");
			
		}else { // 이메일 중복 X --> 사용가능
			out.print("success");
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
