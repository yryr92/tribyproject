package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.triby.host.model.service.HostService;

/**
 * Servlet implementation class findHost
 */
@WebServlet("/findId.ho")
public class FindHostIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindHostIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String hostName = request.getParameter("name");
		String hostPhone = request.getParameter("phone");
		
		String findIdHost = new HostService().findID(hostName, hostPhone);
		
		
	
		if(findIdHost!=null) {
//			request.setAttribute("findIdHost", findIdHost);
//			request.getRequestDispatcher("views/host/findIDview(host).jsp").forward(request, response);
			JSONObject jObj = new JSONObject();
			jObj.put("findIdHost", findIdHost);
			jObj.put("status", "success");
			response.getWriter().print(jObj);
		}else {
			JSONObject jObj = new JSONObject();
			jObj.put("status", "fail");
			
			response.getWriter().print(jObj);
//			request.setAttribute("msg", "아이디 찾기 실패");
			
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
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
