package com.triby.option.model.dao;

import static com.triby.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class OptionDao {

	private Properties prop = new Properties();
	
	public OptionDao() {
		String fileName = OptionDao.class.getResource("/com/triby/sql/option/option-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int adminUpdateOptionStatus(Connection conn, int tNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateOptionStatus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int adminCheckToption(Connection conn, int tNo) {
		// TODO Auto-generated method stub
		int checkCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminCheckToption");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				checkCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return checkCount;
	}

}
