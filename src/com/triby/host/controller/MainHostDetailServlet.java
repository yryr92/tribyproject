package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class MainHostDetailServlet
 */
@WebServlet("/detail.ho")
public class MainHostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainHostDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hNo=Integer.parseInt(request.getParameter("hNo"));
		String tag=request.getParameter("tag");
		Host h=new HostService().mainHostDetail(hNo);
		if(h!=null) {
			request.setAttribute("host", h);
			request.setAttribute("tag", tag);
			request.getRequestDispatcher("views/main/hostProfile.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "존재하지 않는 호스트입니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
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
