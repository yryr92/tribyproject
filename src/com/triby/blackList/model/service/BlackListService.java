package com.triby.blackList.model.service;

import static com.triby.common.JDBCTemplate.close;
import static com.triby.common.JDBCTemplate.commit;
import static com.triby.common.JDBCTemplate.getConnection;
import static com.triby.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.blackList.model.dao.BlackListDao;
import com.triby.blackList.model.vo.BlackList;

public class BlackListService {

	/**
	 * 블랙리스트에 신고대상자를 등록하는 서비스
	 * @param target
	 * @return
	 */
	public ArrayList<BlackList> adminInsertBlacklist(int target) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = new BlackListDao().adminInsertBlacklist(conn, target);
		
		ArrayList<BlackList> list = new ArrayList<>();
		if(result>0) {
			commit(conn);
			list= new BlackListDao().adminSelectBlackList(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	/**
	 * 블랙리스트 조회 서비스
	 * @return
	 */
	public ArrayList<BlackList> adminSelectBlackList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<BlackList> list = new BlackListDao().adminSelectBlackList(conn);
		
		close(conn);
		return list;
	}
	
	/**
	 * 블랙리스트 대상자 여부 조회
	 * @param target
	 * @return
	 */
	public int adminSelectTarget(int target) {
		
		Connection conn = getConnection();
		int check = new BlackListDao().adminSelectTarget(conn, target);
		
		close(conn);
		return check;
	}

	/**
	 * 블랙회원 탈퇴 서비스
	 * @param target
	 * @return
	 */
	public int adminDeleteBlacklist(int target) {//from pak 10/03 수정
		// TODO Auto-generated method stub
		 Connection conn = getConnection();
		 int result = 0;
		 int result1 = 0;
		 String targetStr = String.valueOf(target);
		 if(targetStr.charAt(1)=='1') {
			 result1 = new BlackListDao().adminDeleteTargetMem(conn, target);			 
		 }else {
			 result1 = new BlackListDao().adminDeleteTargetHost(conn, target);
		 }
		System.out.println("result1:"+result1);
		 if(result1>0) {
			 int result2 = new BlackListDao().adminDeleteBlacklist(conn, target);
			 System.out.println("result2:"+result2);
			 if(result2>0) {
				 commit(conn);
				 result = 1;
				 
			 }else {
				 rollback(conn);
			 }	 
		 }else {
			 rollback(conn);
		 }
		 return result;
	}

/////////////////////////from PAK 10/01////////////////////////////////////////

}
