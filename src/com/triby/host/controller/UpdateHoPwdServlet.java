package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;

/**
 * Servlet implementation class UpdateHoPwdServlet
 */
@WebServlet("/updatePwd.ho")
public class UpdateHoPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHoPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String hostEmail = request.getParameter("email");
		String newPwd = request.getParameter("newPwd");
		
		int result = new HostService().updatePwd(hostEmail, newPwd);
		
		if(result>0) {
			
			request.setAttribute("successHoPwd", "비밀번호 변경을 성공하였습니다.");
			
//			request.getRequestDispatcher("/views/host/indexHost.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			
			request.setAttribute("msg", "비밀번호 변경에 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
