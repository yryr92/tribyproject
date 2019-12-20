package com.triby.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class MyPageLikeTribyServlet
 */
@WebServlet("/myLikeTriby")
public class MyPageLikeTribyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageLikeTribyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")!=null) {
//			Member m=(Member)session.getAttribute("loginUser");
//			ArrayList<Triby> list=new MemberService().selectLikeTribyList(m);
//			Gson gson=new Gson();
//			gson.toJson(list, response.getWriter());
			request.getRequestDispatcher("/views/member/myPage.jsp").forward(request,response);
			
			
		}else {
			request.setAttribute("msg","비정상적인 접근");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
//		System.out.println(m);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
