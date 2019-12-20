package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;


/**
 * Servlet implementation class UpdateTribyFormServlet
 */
@WebServlet("/updateForm.tr")
public class UpdateTribyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTribyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tNo = Integer.parseInt(request.getParameter("tNo"));
		
		Triby tr = new TribyService().selectUpdateTriby(tNo);
		
		ArrayList<Image> list = new TribyService().selectImgListT(tNo);
		
		if(tr != null) {
			request.setAttribute("tr", tr);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/host/updateTriby.jsp").forward(request, response);
		} else {
			System.out.println("널입니다.");
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
