package com.triby.triby.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.triby.common.MyFileRenamePolicy;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.service.TribyService;
import com.triby.triby.model.vo.Triby;

/**
 * Servlet implementation class InsertTribyServlet
 */
@WebServlet("/insert.tr")
public class InsertTribyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTribyServlet() {
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
			
			String savePath = root + "/images/triby/";
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> originFiles = new ArrayList<>(); // 원본명들만 담길 list
			ArrayList<String> changeFiles = new ArrayList<>(); // 수정명들만 담길 list
			
			// gefFileName() - 폼에서 전송된 파일 리스트들의 name값들 반환
			Enumeration<String> files = multiRequest.getFileNames(); //  전송 순서 역순으로 쌓임
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				// 파일이 존재할 경우
				if(multiRequest.getFilesystemName(name) != null) {
					
					// getOriginalFileName() - 실제 사용자가 업로드 할 때의 파일명
					String originName = multiRequest.getOriginalFileName(name);
					// getFilesystemName() - rename된 파일명(즉, 서버에 업로드된 파일명)
					String changeName = multiRequest.getFilesystemName(name);
					
					originFiles.add(originName);
					changeFiles.add(changeName);
					
				}
			}
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("tribyContent");
			String content1 = multiRequest.getParameter("content1");
			String content2 = multiRequest.getParameter("content2");
			String content3 = multiRequest.getParameter("content3");
			int hNo = Integer.parseInt(multiRequest.getParameter("loginHostno"));
			
			String[] cId = multiRequest.getParameterValues("category");
			
			String cId1 = cId[0];
			String cId2 = cId[1];
			String cId3 = cId[2];
			
			String address = multiRequest.getParameter("address");
			
			int tPrice = Integer.parseInt(multiRequest.getParameter("price"));
			
			Triby tr = new Triby(title, content, content1, content2, content3, hNo, cId1, cId2, cId3, address, tPrice);

			ArrayList<Image> list = new ArrayList<>();
			
			// 전송 역순으로 changeFiles, originFiles에 저장되어있기 때문에 반복문을 역으로 수행함
			for(int i=originFiles.size()-1; i>=0; i--) {
				
				Image img = new Image();
				img.setiSrc(savePath);
				img.setiName(changeFiles.get(i));
				
				// 대표이미지는 originFiles의 마지막 인덱스
				if(i == originFiles.size()-1) {
					img.setiLev(1);
				} else {
					img.setiLev(2);
				}
				
				list.add(img);
				
			}
			
			int result = new TribyService().insertTriby(tr, list);
			
			//System.out.println(hNo);
			// 아 설마 여긴 multi 어쩌구로 작업해서..? 그거말곤 차이점이 없는디
			//System.out.println(hNo);
			if(result > 0) {
				//System.out.println(hNo);
				/*request.setAttribute("hNo", hNo);
				request.setAttribute("status", 0);
				request.setAttribute("page", 1);
				response.sendRedirect("myTriby.ho");*/
				//request.getRequestDispatcher("views/host/myTriby.jsp").forward(request, response);
				
				request.getRequestDispatcher("views/host/hiddenIndex.jsp").forward(request, response);
				
			} else {
				System.out.println("실패");
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
