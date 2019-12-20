package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class AdminUpdateHostPwServlet
 */
@WebServlet("/updateHostPw.ad")
public class AdminUpdateHostPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateHostPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPw = request.getParameter("newPw");
		
		
		HttpSession session = request.getSession();
		Host h = (Host)session.getAttribute("loginHost");
		int hostNo = h.getHost_no();
		int result = new HostService().updateHostPwAdmin(hostNo, newPw);
		if(result>0) {
			
			request.setAttribute("msg", "성공적으로 수정되었습니다");
		}else {
			request.setAttribute("msg", "오류가 났습니다 다시 수정해 주세요");
		}
		//response.sendRedirect(request.getContextPath()+"/myPage.ho");
		request.getRequestDispatcher("/views/admin/miscellaneous/pwUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
