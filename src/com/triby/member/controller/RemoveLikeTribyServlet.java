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
import com.triby.triby.model.service.MainService;

/**
 * Servlet implementation class RemoveLikeTribyServlet
 */
@WebServlet("/removeLikeTriby.me")
public class RemoveLikeTribyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLikeTribyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int tNo=Integer.parseInt(request.getParameter("tNo"));
		if(session.getAttribute("loginUser")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			int result=new MemberService().removeLikeTriby(m,tNo);
			int result2=new MainService().tribyRemove(tNo);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("로그인 후 이용해주세요");
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
