package com.triby.calculate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.calculate.model.service.CalculateService;

/**
 * Servlet implementation class AdminInsertCalculateServlet
 */
@WebServlet("/insertCal.ad")
public class AdminInsertCalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertCalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//JSONObject json = request.getParameter("realData");
/*		Gson gson = new Gson();
		String[] arr = gson.fromJson(request.getParameter("realData"), String[].class);
		//String str = 

		System.out.println(arr);*/
	
		//System.out.println(sum);
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		int result = new CalculateService().adminCalculateDone(cNo);
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/calListView.ad");
		}else {
			request.setAttribute("msg", "다시 시도해 주세요");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
		}
		
	
/*		int result = new CalculateService().adminInsertCalculate(arr);
		
		if(result>0) {
			request.setAttribute("calMsg", "정산요청이 완료되었습니다");
			request.getRequestDispatcher("/views/admin/calculate/calculateDetailView.jsp").forward(request,response);
		}else {
			request.setAttribute("msg", "오류가 발생하였습니다 다시 시도해주세요");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request,response);
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
