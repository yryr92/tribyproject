package com.triby.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.triby.member.model.service.MemberService;

/**
 * Servlet implementation class FIndMember
 */
@WebServlet("/findId.me")
public class FIndMemberIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("name");
		String userPhone = request.getParameter("phone");
		
		
		String findID = new MemberService().findID(userName,userPhone);
	
		
		if (findID != null) {
			
//			request.setAttribute("findID",findID);
//			 request.getRequestDispatcher("views/member/findIDview.jsp").forward(request, response);
	
	//		 response.getWriter().print("success");
			JSONObject jObj = new JSONObject();
			jObj.put("findID", findID);
			jObj.put("status", "success");
			response.getWriter().print(jObj);
		}else {
			JSONObject jObj = new JSONObject();
			jObj.put("status", "fail");
			
			response.getWriter().print(jObj);
//			request.setAttribute("msg", "아이디찾기실패");
			
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
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
