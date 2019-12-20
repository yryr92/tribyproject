package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;

/**
 * Servlet implementation class FindHostPwdServlet
 */
@WebServlet("/findPwd.ho")
public class FindHostPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindHostPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String hostName = request.getParameter("name");
		String hostEmail = request.getParameter("email");
		String hostPhone = request.getParameter("phone");
		
		int result = new HostService().findPwd(hostName, hostEmail, hostPhone);
		
		if(result >0){
			request.setAttribute("hostEmail", hostEmail);
			request.getRequestDispatcher("views/host/changeHoPwd.jsp").forward(request, response);
		}else {
			
			request.setAttribute("failHopwd", "입력하신 정보가 다릅니다.");	
			request.getRequestDispatcher("views/host/findHoPwd.jsp").forward(request, response);
			
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
