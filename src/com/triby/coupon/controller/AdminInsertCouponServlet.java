package com.triby.coupon.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triby.coupon.model.service.CouponService;
import com.triby.coupon.model.vo.Coupon;

/**
 * Servlet implementation class AdminInsertCouponServlet
 */
@WebServlet("/insertCoupon.ad")
public class AdminInsertCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Coupon cou = new Coupon();
		cou.setcNo(Integer.parseInt(request.getParameter("couponNo")));
		cou.setcName(request.getParameter("couponName"));
		cou.setDiscountRate(Integer.parseInt(request.getParameter("discountRate")));
		cou.setCouponEnd(request.getParameter("couponEnd"));
		cou.setuNo(Integer.parseInt(request.getParameter("userNo")));
		
		int result = new CouponService().adminInsertCoupon(cou);
		
		if(result>0) {
			request.setAttribute("successCoupon", "쿠폰이 발급되었습니다");
			request.getRequestDispatcher("/views/admin/coupon/insertCouponFormView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "쿠폰발급에 실패했습니다 다시 시도해 주세요");
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
