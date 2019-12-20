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
 * Servlet implementation class UpdateMyCategoryServlet
 */
@WebServlet("/updateMyCategory.me")
public class UpdateMyCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			String category=request.getParameter("category");
			int result=new MemberService().updateMyCategory(m,category);
			if(result>0) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print(result);
				m.setCategory(category);
			}
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
