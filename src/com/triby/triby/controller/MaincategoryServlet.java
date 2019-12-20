package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.triby.model.service.MainService;
import com.triby.triby.model.vo.ThumbnailTriby;

/**
 * Servlet implementation class MaincategoryServlet
 */
@WebServlet("/category.ma")
public class MaincategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaincategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		ArrayList<ThumbnailTriby> cListH = new MainService().selectCList(category);
		ArrayList<ThumbnailTriby> cListV = new MainService().selectClistv(category);
		ArrayList<ThumbnailTriby> cListN = new MainService().selectClistn(category);
		
		switch(category) {
			case "AC" : category = "액티비티"; break; 
			case "AC1" : category = "아웃도어"; break; 
			case "AC2" : category = "워터파크"; break; 
			case "AC3" : category = "수상레저"; break; 
			case "AC4" : category = "투어"; break; 
			case "AC5" : category = "축제"; break; 
			case "AC6" : category = "공연"; break; 
			case "AC7" : category = "전시"; break; 
			case "AC8" : category = "실내체험"; break; 
			case "ST" : category = "배움"; break; 
			case "ST1" : category = "스포츠"; break; 
			case "ST2" : category = "음악"; break; 
			case "ST3" : category = "미술"; break; 
			case "ST4" : category = "공예"; break; 
			case "ST5" : category = "요리"; break; 
			case "ST6" : category = "음료"; break; 
			case "ST7" : category = "영상"; break; 
			case "ST8" : category = "사진"; break; 
			case "ST9" : category = "외국어"; break; 
			case "ST10" : category = "독서"; break; 
			case "HB" : category = "건강/뷰티"; break; 
			case "HB1" : category = "피트니스"; break; 
			case "HB2" : category = "요가"; break; 
			case "HB3" : category = "필라테스"; break; 
			case "HB4" : category = "스파"; break; 
			case "HB5" : category = "심리"; break; 
			case "HB6" : category = "상담"; break;
		}
		
		request.setAttribute("category", category);
		request.setAttribute("cListH", cListH);
		request.setAttribute("cListV", cListV);
		request.setAttribute("cListN", cListN);
		
		request.getRequestDispatcher("views/main/categorySearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
