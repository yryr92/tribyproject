package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class HostLoginServlet
 */
@WebServlet("/login.ho")
public class HostLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		Host loginHost = new HostService().loginHost(email, pw);
		
		ArrayList<Integer> HostPlus = new HostService().HostInformation(loginHost);
		
		loginHost.setThisMtriby(HostPlus.get(0));
		loginHost.setAllTriby(HostPlus.get(1));
		loginHost.setReviewCount(HostPlus.get(2));
		loginHost.setThisMsales(HostPlus.get(3));
		loginHost.setAllsales(HostPlus.get(4));
		
		double avg = new HostService().ReviewAverage(loginHost);
		loginHost.setAvgPoint(avg);
		
		double answer = new HostService().qnaAnswerPercent(loginHost);
		loginHost.setQnaAnswer(answer);
		
		
		if(loginHost != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginHost", loginHost);
			request.getRequestDispatcher("views/host/hiddenIndex.jsp").forward(request, response);
			
		} /*else {

			request.setAttribute("msg","로그인 실패" );
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
