package com.triby.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;
import org.json.simple.JSONObject;

import com.triby.member.model.service.MemberService;

/**
 * Servlet implementation class FindMemberPwdServlet
 */
@WebServlet("/findPwd.me")
public class FindMemberPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		

		String userEmail = request.getParameter("email");
		String userName = request.getParameter("name");
		String userPhone = request.getParameter("phone");
		
		
		int result = new MemberService().findPwd(userEmail,userName,userPhone);
		
		System.out.println(result);
		
		if(result > 0) {
			
			request.setAttribute("userEmail", userEmail);
			request.getRequestDispatcher("views/member/changePwd.jsp").forward(request, response);
			
//			JSONObject jObj = new JSONObject();
//			jObj.put("findPwd", findPwd);
//			jObj.put("status", "success");
			
//			response.getWriter().print(jObj);
		}else {
//			JSONObject jObj = new JSONObject();
//			jObj.put("status", "fail");
			
//			response.getWriter().print(jObj);
			request.setAttribute("failPwd", "입력하신 정보가 다릅니다.");
			request.getRequestDispatcher("views/member/findPwd.jsp").forward(request, response);
			
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
