package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.common.PageInfo;
import com.triby.triby.model.service.MainService;
import com.triby.triby.model.vo.ThumbnailTriby;

/**
 * Servlet implementation class MainSearchPriceServlet
 */
@WebServlet("/searchPrice.ma")
public class MainSearchPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainSearchPriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search= request.getParameter("search");
		
		// 검색어 결과 갯수 저장 리스트
		int sp = new MainService().searchListCount(search);
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int pageLimit;		// 한 페이지 하단에 보여질 페이지 수
		int boardLimit; 	// 한 페이지에 보여질 게시글 최대 수
		int maxPage;		// 전체 페이지에서 제일 마지막 페이지 --> listCount, boardLimit을 통해 알아낼 것
		int startPage;		// 한 페이지 하단에 보여질 시작 페이지 --> currentPage, pageLimit을 통해 알아낼 것
		int endPage;		// 한 페이지 하단에 보여질 마지막 페이지 --> startPage 
		
		pageLimit = 5;
		boardLimit = 12;
		
		maxPage = (int)Math.ceil((double)sp / boardLimit);
		
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(sp, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<ThumbnailTriby> slist = new MainService().searchPriceList(search, pi);
		
		request.setAttribute("pi",pi);
		request.setAttribute("slist", slist);
		request.setAttribute("search",search);
		
		request.getRequestDispatcher("views/main/search.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
