package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.triby.triby.model.service.MainService;
import com.triby.triby.model.vo.ThumbnailTriby;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class MainNewServlet
 */
@WebServlet("/mainNew.ma")
public class MainNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ArrayList<Triby> nTriby = new MainService().selectnList();
		ArrayList<ThumbnailTriby> nList = new MainService().selectNlist();
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		gson.toJson(nList, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
