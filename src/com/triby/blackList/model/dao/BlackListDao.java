package com.triby.blackList.model.dao;

import static com.triby.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.triby.blackList.model.vo.BlackList;


public class BlackListDao {
	
	private Properties prop = new Properties();
	
	public BlackListDao() {
		
		String fileName = BlackListDao.class.getResource("/com/triby/sql/admin/blacklist-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int adminInsertBlacklist(Connection conn, int target) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertBlacklist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}
	public ArrayList<BlackList> adminSelectBlackList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<BlackList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectBlackList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BlackList(rset.getInt("BLACK_NO"),
									   rset.getInt("BLACK_TARGET"),
									   rset.getString("M_DATE")));
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
	public int adminSelectTarget(Connection conn, int target) {
		// TODO Auto-generated method stub
		int check = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectTarget");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				check = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return check;

	}
	public int adminDeleteTargetMem(Connection conn, int target) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminDeleteTargetMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int adminDeleteBlacklist(Connection conn, int target) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminDeleteBlacklist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
////////////////////////////from PAK 10/01//////////////////////////////////

	public int adminDeleteTargetHost(Connection conn, int target) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminDeleteTargetHost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
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
