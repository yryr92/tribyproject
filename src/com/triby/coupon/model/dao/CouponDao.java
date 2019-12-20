package com.triby.coupon.model.dao;

import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.triby.coupon.model.vo.Coupon;
import static com.triby.common.JDBCTemplate.*;

public class CouponDao {

	private Properties prop = new Properties();
	
	public CouponDao() {
		String fileName = CouponDao.class.getResource("/com/triby/sql/admin/coupon-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public int adminInsertCoupon(Connection conn, Coupon cou) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cou.getcNo());
			pstmt.setString(2,cou.getcName());
			pstmt.setInt(3, cou.getDiscountRate());
			pstmt.setString(4, cou.getCouponEnd());
			pstmt.setInt(5, cou.getuNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
