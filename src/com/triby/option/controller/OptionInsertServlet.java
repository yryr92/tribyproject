package com.triby.option.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.option.model.vo.Option;
import com.triby.triby.model.service.TribyService;

/**
 * Servlet implementation class OptionInsertServlet
 */
@WebServlet("/insert.op")
public class OptionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Option op = new Option();
		
		int tId = Integer.parseInt(request.getParameter("tNo"));
		int minP = Integer.parseInt(request.getParameter("minimumP"));
		int maxP = Integer.parseInt(request.getParameter("maximumP"));
		
		ArrayList<String> days = new ArrayList<>();
		String[] day = request.getParameterValues("date");
		
		for(int i=0; i<day.length; i++) {
			days.add(day[i]);
			System.out.println(day[i]);
		}
		
		ArrayList<String> times = new ArrayList<>();
		String[] time = request.getParameterValues("time");
		
		for(int i=0; i<time.length; i++) {
			times.add(time[i]);
		}
		
		op.settId(tId);
		op.setPerson_min(minP);
		op.setPerson_max(maxP);
		
		int result = new TribyService().insertOption(op, days, times);
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		
		if(result > 0) {
			request.setAttribute("status", 1);
			request.setAttribute("hNo", hNo);
			request.getRequestDispatcher("myTriby.ho").forward(request, response);
			
		} else {
			System.out.println("option insert 실패");
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
