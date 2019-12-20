package com.triby.option.model.service;

import static com.triby.common.JDBCTemplate.*;
import static com.triby.common.JDBCTemplate.getConnection;
import static com.triby.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.triby.option.model.dao.OptionDao;

public class OptionService {

	
	/**
	 * 트리비 승인시 옵션이 있을경우 동시에 승인하는 서비스
	 * @param tNo
	 * @return
	 *//*
	public void adminCheckToption(int tNo) {
		Connection conn = getConnection();
		int checkCount = new OptionDao().adminCheckToption(conn, tNo);
		if(checkCount>0) {
			int result = new OptionDao().adminUpdateOptionStatus(conn, tNo);
			if(result> 0) {
				commit(conn);
			}else {
				rollback(conn);
			}			
		}
	}*/
	///////////////////////////from pak 10/08////////////////////
////from pak 10/14
	/**
	 * 해당 트리비에 옵션이 들어있는지 체크하는 서비스
	 * @param tNo
	 * @return
	 */
	public int adminCheckToption(int tNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int check = new OptionDao().adminCheckToption(conn, tNo);
		close(conn);
		return check;
	}
}
