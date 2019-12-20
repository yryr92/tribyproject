package com.triby.triby.controller;

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
import com.triby.triby.model.service.MainService;
import com.triby.triby.model.vo.ThumbnailTriby;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/mainHot.ma")
public class MainHotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainHotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArrayList<Triby> tList = new MainService().selecttList();	// tID(int), tTitle(String), tPrice(int), tLike(int)
		ArrayList<ThumbnailTriby> tList = new MainService().selectHList();	// tID(int), tTitle(String), tPrice(int), tLike(int)
//		ArrayList<Triby> test = new ArrayList<>();
		
		response.setContentType("application/json; charset=UTF-8");
		
//		HashMap map = new HashMap();
		
//		map.put("tList", tList);
//		map.put("tImg", tImg);  // 이미지 이름  / 트리비 번호
		
		Gson gson = new Gson();
		gson.toJson(tList, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
