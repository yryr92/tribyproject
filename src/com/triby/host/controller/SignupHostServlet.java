package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class SignupHostServlet
 */
@WebServlet("/signup.ho")
public class SignupHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String hostEmail = request.getParameter("email"); // 아이디
		String hostPwd = request.getParameter("host_pwd");		// 비밀번호
		String hostRn = request.getParameter("host_rn");		// 사업자 등번
		String hostsName = request.getParameter("sName"); // 상호명		
		String hostName = request.getParameter("name"); // 이름
		String hostPhone = request.getParameter("host_phone");  
		String hostAccountName = request.getParameter("accountName");
		String bankName = request.getParameter("bank_Name");
		String hostAccount = request.getParameter("account");
		String hostIntroduce = request.getParameter("host_introduce");
		
		Host ho = new Host(hostEmail, hostPwd, hostRn, hostsName, hostName, hostPhone, hostAccountName, bankName, hostAccount,hostIntroduce); 
	
		int result = new HostService().signHost(ho);	
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("joinSuccessMsg", "회원가입성공");
			session.setAttribute("loginHost",ho);
			
			request.getRequestDispatcher("/views/host/indexHost.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "회원가입실패");
			
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
