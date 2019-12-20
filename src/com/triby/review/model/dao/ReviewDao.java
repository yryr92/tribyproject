package com.triby.review.model.dao;

import static com.triby.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.triby.common.PageInfo;
import com.triby.member.model.vo.Member;
import com.triby.review.model.vo.Review;
import com.triby.review.model.vo.ReviewHost;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String fileName = ReviewDao.class.getResource("/com/triby/sql/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getListCountH(Connection conn, int hNo) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("getListCountH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return result;
	}

	public ArrayList<ReviewHost> selectListH(Connection conn, int hNo, PageInfo pi) {
		
		ArrayList<ReviewHost> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectListH");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			ps.setInt(1, hNo);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReviewHost rv = new ReviewHost();
				rv.setRvNo(rs.getInt("review_no"));
				rv.sethNo(rs.getInt("host_no"));
				rv.setUser_name(rs.getString("user_name"));
				rv.setRvContent(rs.getString("review_content"));
				rv.setRvPoint(rs.getInt("review_point"));
				rv.setRvDate(rs.getDate("review_date") + " " + rs.getTime("review_date"));
				rv.setReply(rs.getString("review_reply"));
				rv.setTriby(rs.getString("triby_title"));
				rv.setuNo(rs.getInt("user_no"));
				
				list.add(rv);
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

	public int insertMemberReview(Connection conn, Review rv) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMemberReview");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rv.getpNo());
			pstmt.setInt(2, rv.gethNo());
			pstmt.setInt(3, rv.getuNo());
			pstmt.setString(4, rv.getRvContent());
			pstmt.setInt(5, rv.getRvPoint());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public String selectMyReviewContent(Connection conn, int rNo) {
		String str=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyReviewContent");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				str=rset.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return str;
		
		
	}

	public int updateMemberReview(Connection conn, Review r) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemberReview");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, r.getRvContent());
			pstmt.setInt(2, r.getRvPoint());
			pstmt.setInt(3, r.getRvNo());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}

	public int deleteMemberReview(Connection conn, int rNo) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMemberReview");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	

}
