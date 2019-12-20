package com.triby.member.controller;

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
import com.triby.member.model.service.MemberService;
import com.triby.member.model.vo.Member;

/**
 * Servlet implementation class UpdateProfileImageServlet
 */
@WebServlet("/uploadProfileImg.me")
public class UpdateProfileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			Member m=(Member)session.getAttribute("loginUser");
			if(ServletFileUpload.isMultipartContent(request)) {
				int maxSize=10*1024*1024;
				String root = request.getSession().getServletContext().getRealPath("/resources");
				String savePath = root + "/images/user/profile/";
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				Enumeration<String> files = multiRequest.getFileNames();
				String changeName="";
				if(files.hasMoreElements()) {
					String name = files.nextElement();
					if(multiRequest.getFilesystemName(name) != null) {
						changeName = multiRequest.getFilesystemName(name);
					}
				}
				if(!changeName.equals("")) {
					int result=new MemberService().updateProfileImage(m,changeName);
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().print(result);
				}
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
