package com.triby.qnaHost.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.triby.common.JDBCTemplate.close;

import com.triby.common.PageInfo;
import com.triby.qnaHost.model.vo.QnA;

public class QnADao {
	
	private Properties prop = new Properties();
	
	public QnADao() {
		
		String fileName = QnADao.class.getResource("/com/triby/sql/qna/qna-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<QnA> selectListH(Connection conn, int hNo, int status, PageInfo pi) {
		
		ArrayList<QnA> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		switch(status) {
		case 0: sql = prop.getProperty("selectListH0"); break;
		case 1: sql = prop.getProperty("selectListH1"); break;
		case 2: sql = prop.getProperty("selectListH2"); break;
		}
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			ps.setInt(1, hNo);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				QnA qa = new QnA();
				qa.setqNo(rs.getInt("QNA_H_NO"));
				qa.setuNo(rs.getInt("USER_NO"));
				qa.sethNo(rs.getInt("host_no"));
				qa.setqTitle(rs.getString("qna_h_title"));
				qa.setqContent(rs.getString("qna_h_q"));
				qa.setqAnswer(rs.getString("qna_h_a"));
				qa.setqDate(rs.getString("QNA_H_DATE"));
				qa.setaDate(rs.getString("QNA_H_ADATE"));
				qa.setqStatus(rs.getString("QNA_H_STATUS"));
				qa.setqSecret(rs.getString("QNA_H_SECRET"));
				qa.setUser_name(rs.getString("user_name"));
				
				list.add(qa);
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

	public int getListCountH(Connection conn, int hNo, int status) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		switch(status) {
		case 0: sql = prop.getProperty("getListCountH0"); break;
		case 1: sql = prop.getProperty("getListCountH1"); break;
		case 2: sql = prop.getProperty("getListCountH2"); break;
		}
		
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

	public int updateQnA(Connection conn, int qNo, String answer) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateQnA");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, answer);
			ps.setInt(2, qNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		
		return result;
	}

	public int insertMyQna(Connection conn, QnA q) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertMyQna");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, q.getuNo());
			ps.setInt(2, q.gethNo());
			ps.setString(3, q.getqTitle());
			ps.setString(4, q.getqContent());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	


}
