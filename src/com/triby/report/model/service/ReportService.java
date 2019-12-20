package com.triby.report.model.service;

import static com.triby.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.common.PageInfo;
import com.triby.report.model.dao.ReportDao;
import com.triby.report.model.vo.Report;

public class ReportService {

	/**
	 * 신고 리스트 조회 서비스
	 * @return 신고리스트
	 */
	public ArrayList<Report> adminSelectReportList(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn =  getConnection();
		ArrayList<Report> list = new ReportDao().adminSelectReportList(conn, pi);
		
		close(conn);

		return list;
	}

	/**
	 * 리스트 총 갯수 조회 서비스
	 * @return
	 */
	public int adminGetListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = 0;
		listCount = new ReportDao().adminGetListCount(conn);
		
		close(conn);

		return listCount;
	}
/////////////////////////from PAK 10/01/////////////////////////////

	/**
	 * 블랙리스트에 등재된 회원에 대한 상세한 신고 내역조회
	 * @param target
	 * @return
	 */
	public ArrayList<Report> adminSelectTargetList(int target) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Report> targetList = new ReportDao().adminSelectTargetList(conn, target);
		
		close(conn);
		return targetList;
	}

	public int insertReport(Report re, int status) {
		
		Connection conn = getConnection();
		
		int result1 = new ReportDao().insertReport(conn, re);
		int result2 = new ReportDao().updateReportCount(conn, re, status);
		int result = 0;
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		
		return result;
	}
	////////start from pak 10/15
	/**
	 * 釉붾옓由ъ뒪�듃�뿉 �엳�뒗 ���긽�옄�뿉 愿��븳 �떊怨좊━�뒪�듃 議고쉶 �꽌鍮꾩뒪
	 * @param targetStr
	 * @return
	 */
	public ArrayList<Report> adminSelectTargetCheckList(String targetStr) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Report> list = new ArrayList<>();
		if(targetStr.charAt(0)=='1') {
			list = new ReportDao().adminSelectTargetList(conn,Integer.parseInt(targetStr));
		}else {
			list = new ReportDao().adminSelectTargetHostList(conn,Integer.parseInt(targetStr));
		}
		close(conn);
		return list;
	}
}
