package com.triby.report.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.triby.common.PageInfo;
import com.triby.report.model.vo.Report;
import static com.triby.common.JDBCTemplate.*;

public class ReportDao {
	
	private Properties prop = new Properties();
	
	public ReportDao() {
		
		String fileName = ReportDao.class.getResource("/com/triby/sql/report/report-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Report> adminSelectReportList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Report> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Report(rset.getInt("REP_NO"),
									rset.getString("REP_DETAIL"),
									rset.getDate("REP_DATE"),
									rset.getInt("REP_REPORTER"),
									//from pak 10/15
									rset.getInt("REP_TARGET"),
									rset.getString("USER_NAME"),
									rset.getString("HOST_NAME")));
									//end from pak 10/15
									
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

	public int adminGetListCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
////////////////////////////from PAK 10/01/////////////////////////////////	

	public ArrayList<Report> adminSelectTargetList(Connection conn, int target) {
		// TODO Auto-generated method stub
		ArrayList<Report> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectTargetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Report(rset.getInt("REP_NO"),
									rset.getString("REP_DETAIL")+"/"+rset.getString("HOST_NAME"),
									rset.getDate("REP_DATE"),
									rset.getInt("REP_REPORTER"),
									rset.getInt("REP_TARGET")));
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

	public int insertReport(Connection conn, Report re) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertReport");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, re.getrDetail());
			ps.setInt(2, re.getrReporter());
			ps.setInt(3, re.getrTarget());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int updateReportCount(Connection conn, Report re, int status) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = "";
		
		if(status == 0) {
			sql = prop.getProperty("updateReportCountH");
		} else {
			sql = prop.getProperty("updateReportCountM");
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, re.getrTarget());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	///from pak 10/15
		public ArrayList<Report> adminSelectTargetHostList(Connection conn, int target) {
			// TODO Auto-generated method stub
			ArrayList<Report> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("adminSelectTargetHostList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, target);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new Report(rset.getInt("REP_NO"),
							rset.getString("REP_DETAIL")+"/"+rset.getString("USER_NAME"),
							rset.getDate("REP_DATE"),
							rset.getInt("REP_REPORTER"),
							rset.getInt("REP_TARGET")));
						
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
		
}
