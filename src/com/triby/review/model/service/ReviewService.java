package com.triby.review.model.service;

import static com.triby.common.JDBCTemplate.*;
import static com.triby.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.common.PageInfo;
import com.triby.member.model.vo.Member;
import com.triby.review.model.dao.ReviewDao;
import com.triby.review.model.vo.Review;
import com.triby.review.model.vo.ReviewHost;

public class ReviewService {

	public int getListCountH(int hNo) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().getListCountH(conn, hNo);
		
		close(conn);
		
		return result;
	}

	public ArrayList<ReviewHost> selectListH(int hNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<ReviewHost> list = new ReviewDao().selectListH(conn, hNo, pi);
		
		close(conn);
		
		return list;
	}

	public int insertMemberReview(Review rv) {
		Connection conn = getConnection();
		int result=new ReviewDao().insertMemberReview(conn,rv);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public String selectMyReviewContent(int rNo) {
		Connection conn = getConnection();
		
		String str = new ReviewDao().selectMyReviewContent(conn,rNo);
		
		close(conn);
		
		return str;
	}

	public int updateMemberReview(Review r) {
		Connection conn = getConnection();
		int result=new ReviewDao().updateMemberReview(conn,r);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteMemberReview(int rNo) {
		Connection conn = getConnection();
		int result=new ReviewDao().deleteMemberReview(conn,rNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

}
