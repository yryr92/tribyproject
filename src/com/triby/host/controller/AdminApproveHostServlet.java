package com.triby.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.host.model.service.HostService;

/**
 * Servlet implementation class AdminApproveHostServlet
 */
@WebServlet("/approveHost.ad")
public class AdminApproveHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminApproveHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hostNo = Integer.parseInt(request.getParameter("hostNo"));
		String disapproval = request.getParameter("disapproval");
		
		int result = 0;
		
		if(disapproval == null) {
			result = new HostService().adminUpdateHostApproval(hostNo);
		}else if(disapproval != null && disapproval.equals("Y")) {
			result = new HostService().adminUpdateHostDisapproval(hostNo);
		}
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/host.ad");
		}else {
			request.setAttribute("msg", "오류가 발생하였습니다 다시 시도해 주세요");
			request.getRequestDispatcher("/views/admin/adminErrorPage.jsp").forward(request, response);
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
