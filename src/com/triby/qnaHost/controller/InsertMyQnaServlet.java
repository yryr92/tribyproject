package com.triby.qnaHost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.member.model.vo.Member;
import com.triby.qnaHost.model.service.QnAService;
import com.triby.qnaHost.model.vo.QnA;

/**
 * Servlet implementation class InsertMyQnaServlet
 */
@WebServlet("/insertQna.me")
public class InsertMyQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMyQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			int hNo=Integer.parseInt(request.getParameter("hNo"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			QnA q=new QnA();
			q.setuNo(m.getuNo());
			q.sethNo(hNo);
			q.setqTitle(title);
			q.setqContent(content);
			
			int result=new QnAService().insertMyQna(q);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
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
