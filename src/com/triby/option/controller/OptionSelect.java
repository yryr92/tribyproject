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
 * Servlet implementation class OptionSelect
 */
@WebServlet("/select.op")
public class OptionSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		
		ArrayList<Option> list = new TribyService().selectOption(tNo);
		
		request.setAttribute("tNo", tNo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/host/optionUpdate.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
