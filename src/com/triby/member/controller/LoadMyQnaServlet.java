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
import com.triby.qnaHost.model.vo.QnA;

/**
 * Servlet implementation class LoadMyQnaServlet
 */
@WebServlet("/QNA.me")
public class LoadMyQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMyQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")!=null&&request.getParameter("page")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			int page=Integer.parseInt(request.getParameter("page"));
			ArrayList<QnA> list=new MemberService().selectMyQnaList(m,page);
			response.setContentType("application/json; charset=UTF-8");
			Gson gson=new Gson();
			gson.toJson(list, response.getWriter());
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
