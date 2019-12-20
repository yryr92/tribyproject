package com.triby.calculate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triby.calculate.model.service.CalculateService;

/**
 * Servlet implementation class AdminUpdateCalServlet
 */
@WebServlet("/updateCal.ad")
public class AdminUpdateCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateCalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
/*		int tOno = Integer.parseInt(request.getParameter("tOno"));
		int result = new CalculateService().updateCalculateDone(tOno);
		
		//HttpSession session = request.getSession();
		
		if(result>0) {
			
			//session.setAttribute("calMsg","정산이 모두 완료되었습니다");
		}else {
			//session.setAttribute("calMsg", "오류가 났습니다 새로고침해주세요");
		}
		response.sendRedirect(request.getContextPath() +"/calListView.ad");*/
		int sum = Integer.parseInt(request.getParameter("sum"));
		int toNo = Integer.parseInt(request.getParameter("toNo"));
		
		int result = new CalculateService().adminUpdateCalculateCom(toNo, sum);
		if(result>0) {
			//response.sendRedirect(request.getContextPath()+"/calListView.ad");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
		}else {
			request.setAttribute("msg", "정산이 되지 않았습니다");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
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
