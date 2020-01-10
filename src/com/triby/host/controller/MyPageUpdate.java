package com.triby.host.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.triby.common.MyFileRenamePolicy;
import com.triby.host.model.service.HostService;
import com.triby.host.model.vo.Host;

/**
 * Servlet implementation class MyPageUpdate
 */
@WebServlet("/update.ho")
public class MyPageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			String root = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = root + "/images/host/profile/";
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			Enumeration<String> file = multiRequest.getFileNames();
			String fileName = "";
			
			while(file.hasMoreElements()) {
				String name = file.nextElement();
				if(multiRequest.getFilesystemName(name) != null) {
					String originName = multiRequest.getOriginalFileName(name);
					fileName = multiRequest.getFilesystemName(name);
				}
			}

			Host h = new Host();
			h.setHost_email(multiRequest.getParameter("email"));
			h.setHost_sName(multiRequest.getParameter("sname"));
			h.setHost_phone(multiRequest.getParameter("phone"));
			h.setHost_introduce(multiRequest.getParameter("introduce"));
			h.setBank_name(multiRequest.getParameter("bankname"));
			h.setAccount(multiRequest.getParameter("account"));
			h.setHost_image(fileName);
			
			Host updateH = new HostService().updateHost(h);
			
			if(updateH != null) {
				//System.out.println("널아님");
				HttpSession session = request.getSession();
				session.setAttribute("loginHost", updateH);
				response.sendRedirect("myPage.ho");
				
			} else {
				System.out.println("에러");
			}

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
