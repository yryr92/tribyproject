package com.triby.qnaHost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;
import com.triby.qnaHost.model.service.QnAService;

/**
 * Servlet implementation class QnAUpdateServlet
 */
@WebServlet("/update.qa")
public class QnAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		String answer = request.getParameter("answer");
		
		int result = new QnAService().updateQnA(qNo, answer);
		HttpSession session = request.getSession();
		
		Host loginHost = (Host) session.getAttribute("loginHost");
		
		double answerP = new HostService().qnaAnswerPercent(loginHost);
		loginHost.setQnaAnswer(answerP);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
