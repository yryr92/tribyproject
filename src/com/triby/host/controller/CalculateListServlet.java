package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.triby.calculate.model.service.CalculateService;
import com.triby.calculate.model.vo.CalculateHost;

/**
 * Servlet implementation class CalculateListServlet
 */
@WebServlet("/calList.ho")
public class CalculateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		ArrayList<CalculateHost> list = new CalculateService().selectCalListH(hNo, status);
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
