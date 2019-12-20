package com.triby.coupon.model.service;

import static com.triby.common.JDBCTemplate.*;

import java.sql.Connection;

import com.triby.coupon.model.dao.CouponDao;
import com.triby.coupon.model.vo.Coupon;

public class CouponService {

	/**
	 * 한명 회원에게 쿠폰 발급하는 서비스
	 * @param cou 쿠폰
	 * @return
	 */
	public int adminInsertCoupon(Coupon cou) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CouponDao().adminInsertCoupon(conn, cou);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
