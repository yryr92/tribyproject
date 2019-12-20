package com.triby.payment.model.dao;

import static com.triby.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.triby.payment.model.vo.Payment;
import com.triby.payment.model.vo.PaymentforHost;

public class PaymentDao {

	private Properties prop = new Properties();
	
	public PaymentDao() {
		String fileName = PaymentDao.class.getResource("/com/triby/sql/payment/payment-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Payment> adminSelectPaymentList(Connection conn) {
		ArrayList<Payment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectPaymentList");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setpNo(rset.getInt("PAYMENT_NO"));
				p.setpDate(rset.getString("PAYMENT_DATE")+"");
				//p.setUno(rset.getInt("USER_NO"));
				p.setpInfo(rset.getString("USER_NAME"));
				p.settONo(rset.getInt("TRIBY_OP_NO"));
				p.setpFinal(rset.getInt("PAYMENT_FINAL"));
				/////////start from pak 10/12
				p.setStatus(rset.getString("STATUS"));
				/////end from pak 10/12
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Payment> adminSelectSumList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Payment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectSumList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.settONo(rset.getInt("TRIBY_OP_NO"));
				p.setpFinal(rset.getInt("C_SUM"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	///////////////////from pak 10/09/////////////////////////////////////

	public ArrayList<PaymentforHost> selectListH(Connection conn, int oNo) {
		
		ArrayList<PaymentforHost> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectListH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PaymentforHost pa = new PaymentforHost();
				pa.setUserName(rs.getString("user_name"));
				pa.setBirth(rs.getString("user_birth"));
				pa.setGender(rs.getString("user_gender"));
				pa.setPhone(rs.getString("user_phone"));
				pa.setpDate(rs.getDate("payment_date"));
				
				list.add(pa);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}
}
