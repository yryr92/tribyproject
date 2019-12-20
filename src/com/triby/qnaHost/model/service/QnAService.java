package com.triby.qnaHost.model.service;

import static com.triby.common.JDBCTemplate.*;
import static com.triby.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.common.PageInfo;
import com.triby.notice.model.vo.Notice;
import com.triby.qnaHost.model.dao.QnADao;
import com.triby.qnaHost.model.vo.QnA;
import com.triby.triby.model.dao.TribyDao;

public class QnAService {

	public ArrayList<QnA> selectListH(int hNo, int status, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<QnA> list = new QnADao().selectListH(conn, hNo, status, pi);
		
		close(conn);
		
		return list;
		
	}

	public int getListCountH(int hNo, int status) {
		
		Connection conn = getConnection();
		
		int result = new QnADao().getListCountH(conn, hNo, status);
		
		close(conn);
		
		return result;
	}

	public int updateQnA(int qNo, String answer) {
		
		Connection conn = getConnection();
		
		int result = new QnADao().updateQnA(conn, qNo, answer);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertMyQna(QnA q) {
		Connection conn = getConnection();
		
		int result = new QnADao().insertMyQna(conn,q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}

