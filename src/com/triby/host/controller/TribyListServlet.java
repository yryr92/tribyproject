package com.triby.host.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class TribyListServlet
 */
@WebServlet("/trList.ho")
public class TribyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TribyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hNo = Integer.parseInt(request.getParameter("hNo"));
		String status = request.getParameter("status");
		
		/*ArrayList<Triby> tList = new TribyService().selectListH(hNo, status);
		ArrayList<Image> iList = new TribyService().selectImgListH(hNo, status);
		
		request.setAttribute("tList", tList);
		request.setAttribute("iList", iList);
		
		HashMap map = new HashMap();
	      
	    map.put("tList", tList);
	    map.put("iList", iList);*/
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		//gson.toJson(map, response.getWriter());
		//gson.toJson(iList, response.getWriter());		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
