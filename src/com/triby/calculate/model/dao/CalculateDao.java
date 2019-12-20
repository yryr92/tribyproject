package com.triby.calculate.model.dao;

import static com.triby.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.triby.calculate.model.vo.Calculate;
import com.triby.calculate.model.vo.CalculateHost;
import com.triby.host.model.vo.Host;
import com.triby.payment.model.vo.Payment;

import static com.triby.common.JDBCTemplate.*;

public class CalculateDao {
	
	private Properties prop = new Properties();
	
	public CalculateDao() {
		String fileName = CalculateDao.class.getResource("/com/triby/sql/calculate/calculate-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int adminGetListCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetListCount");
		return 0;
	}



	public int adminInsertCalculate(Connection conn, ArrayList<Host> list) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertCalculate");

			try {
				for(int i = 0; i <list.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list.get(i).getLike_count());
				pstmt.setInt(2, list.get(i).getReport_count());
				result += pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
	public int adminUpdateOCalculate(Connection conn, ArrayList<Host> list) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateOCalculate");
		try {
			for(Host h : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, h.getLike_count());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public int adminInsertNCalculate(Connection conn, ArrayList<Payment> list) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertNCalculate");
		try {
			for(Payment p : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p.gettONo());
				pstmt.setInt(2, p.getpFinal());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateCalculateDone(Connection conn, int tOno) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCalculateDone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tOno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	////////////////from pak 10/10
	
	public ArrayList<CalculateHost> selectCalListH(Connection conn, int hNo, int status) {
		
		ArrayList<CalculateHost> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		if(status == 0) {
			sql = prop.getProperty("selectCalListH0");
		} else {
			sql = prop.getProperty("selectCalListH1");
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CalculateHost ca = new CalculateHost();
				ca.setTday(rs.getString("tday") + " " + rs.getString("ttime"));
				ca.settTitle(rs.getString("TRIBY_TITLE"));
				ca.settAttend(rs.getInt("TRIBY_ATTEND"));
				ca.setCal_sum(rs.getInt("CAL_SUM"));
				ca.setCal_status(rs.getString("CAL_STATUS"));
				
				list.add(ca);
				
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
		
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		if(status == 0) {
			sql = prop.getProperty("getListCountH0");
		} else {
			sql = prop.getProperty("getListCountH1");
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return listCount;
	}
/////////start from pak 10/12
	public ArrayList<Calculate> adminSelectAllList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Calculate> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Calculate(rset.getInt("CAL_NO"), 
						rset.getInt("TRIBY_OP_NO"),
						rset.getInt("CAL_SUM"),
						rset.getString("CAL_STATUS"),
									   rset.getString("TRIBY_TITLE"),
									   rset.getInt("HOST_NO"),
									   rset.getString("HOST_ACCOUNTNAME")));
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
	
	public int adminUpdateNCalculate(Connection conn, ArrayList<Host> list) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateNCalculate");
		
		try {
			for(Host h : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, h.getLike_count());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public int adminUpdateCalculateCom(Connection conn, int toNo, int sum) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateCalculateCom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, sum);
			//pstmt.setInt(2, toNo);
			pstmt.setInt(1,toNo);
			pstmt.setInt(2, sum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
//////////////////end from pak 10/12	
////start form pak 10/13
	public int adminSelectMemberCount(Connection conn, int menu) {
		// TODO Auto-generated method stub
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		if(menu ==1) {
			sql = prop.getProperty("adminSelectMemberCount");			
		}else if(menu == 2) {
			sql = prop.getProperty("adminSelectCountNewbies");
		}else if(menu == 3) {
			sql = prop.getProperty("adminSelectHostCount");
		}else if(menu == 4) {
			sql = prop.getProperty("adminSelectTribyCount");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}

	public String adminSelectPopular(Connection conn) {
		// TODO Auto-generated method stub
		String pop = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectPopular");
	
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pop = rset.getString("TRIBY_TITLE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return pop;
	}

	public String adminSelectPopHost(Connection conn) {
		// TODO Auto-generated method stub
		String two = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectPopHost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				two = rset.getString("HOST_SNAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return two;
	}
////////from pak 10/14
	public int adminCalculateDone(Connection conn, int cNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminCalculateDone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cNo);
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

