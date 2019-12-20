package com.triby.option.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.triby.model.service.TribyService;

/**
 * Servlet implementation class OptionEndServlet
 */
@WebServlet("/end.op")
public class OptionEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		
		//System.out.println(tNo + "" + oNo);
		
		int result = new TribyService().endOption(tNo, oNo);
		
		if(result > 0) {
			response.getWriter().print("success");
		} else {
			response.getWriter().print("fail");
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
