package com.triby.payment.model.service;

import static com.triby.common.JDBCTemplate.close;
import static com.triby.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.triby.payment.model.dao.PaymentDao;
import com.triby.payment.model.vo.Payment;
import com.triby.payment.model.vo.PaymentforHost;

public class PaymentService {
	
	/**
	 * 정산을 위한 결제내역리스트 조회 서비스
	 * @return 결제내역리스트
	 */
	public ArrayList<Payment> adminSelectPaymentList() {
		Connection conn = getConnection();
		ArrayList<Payment> list = new PaymentDao().adminSelectPaymentList(conn);
		close(conn);
		return list;
	}
	
	/**
	 * 한달전 문자 구하는 서비스
	 * @return 한달전
	 */
	public String adminGetCustomMonth() {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int year = Integer.parseInt(sdf.format(today).substring(0,4));
		int month = Integer.parseInt(sdf.format(today).substring(4,6));
		int date = Integer.parseInt(sdf.format(today).substring(6,8));
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(year,month-1,date);
		cal.add(Calendar.MONTH, -1);
		
		String months = sdf.format(cal.getTime());
		String past = months.substring(4,6);
		return past;
	
	}
	/**
	 * 정산할 리스트 불러오는 서비스
	 * @return 정산용 리스트
	 */
	public ArrayList<Payment> adminSelectSumList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Payment> list = new PaymentDao().adminSelectSumList(conn);
		close(conn);
		return list;
	}
///////////////////from pak 10/09////////////////////		

		public ArrayList<PaymentforHost> selectListH(int oNo) {
		
		Connection conn = getConnection();
		
		ArrayList<PaymentforHost> list = new PaymentDao().selectListH(conn, oNo);
		
		close(conn);
		
		return list;
	}
}
