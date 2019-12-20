package com.triby.host.model.dao;

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
import com.triby.host.model.vo.Host;
import com.triby.review.model.vo.MyReview;
import com.triby.triby.model.vo.ThumbnailTriby;

public class HostDao {
	
	private Properties prop = new Properties();
	
	public HostDao() {
		String fileName = HostDao.class.getResource("/com/triby/sql/host/host-query.properties").getPath();
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

	public ArrayList<Host> selectHostAdmin(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectHostAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
		    pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Host h = new Host();
				h.setHost_no(rset.getInt("HOST_NO"));
				h.setHost_email(rset.getString("HOST_EMAIL"));
				h.setHost_sName(rset.getString("HOST_SNAME"));
				h.setHost_name(rset.getString("HOST_NAME"));
				h.setHost_phone(rset.getString("HOST_PHONE"));
				h.setLike_count(rset.getInt("LIKE_COUNT"));
				h.setReport_count(rset.getInt("REPORT_COUNT"));
				h.setEnroll_date(rset.getDate("ENROLL_DATE"));
				h.setStatus(rset.getString("STATUS"));
				h.setApproval(rset.getString("APPROVAL"));
				h.setHost_introduce(rset.getString("HOST_INTRODUCE"));
				list.add(h);
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
////////////////////from PAK 10/01////////////////////////////////

	public int adminUpdateHostApproval(Connection conn, int hostNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateHostApproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int adminUpdateHostDisapproval(Connection conn, int hostNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateHostDisapproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Host> selectHostAdminStatus(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectHostAdminStatus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
		    pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Host h = new Host();
				h.setHost_no(rset.getInt("HOST_NO"));
				h.setHost_email(rset.getString("HOST_EMAIL"));
				h.setHost_sName(rset.getString("HOST_SNAME"));
				h.setHost_name(rset.getString("HOST_NAME"));
				h.setHost_phone(rset.getString("HOST_PHONE"));
				h.setLike_count(rset.getInt("LIKE_COUNT"));
				h.setReport_count(rset.getInt("REPORT_COUNT"));
				h.setEnroll_date(rset.getDate("ENROLL_DATE"));
				h.setStatus(rset.getString("STATUS"));
				h.setApproval(rset.getString("APPROVAL"));
				h.setHost_introduce(rset.getString("HOST_INTRODUCE"));
				list.add(h);
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

	public ArrayList<Host> adminSearchHostNoList(Connection conn, String input) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSearchHostNoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+input+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Host h = new Host();
				h.setHost_no(rset.getInt("HOST_NO"));
				h.setHost_email(rset.getString("HOST_EMAIL"));
				h.setHost_sName(rset.getString("HOST_SNAME"));
				h.setHost_name(rset.getString("HOST_NAME"));
				h.setHost_phone(rset.getString("HOST_PHONE"));
				h.setLike_count(rset.getInt("LIKE_COUNT"));
				h.setReport_count(rset.getInt("REPORT_COUNT"));
				h.setEnroll_date(rset.getDate("ENROLL_DATE"));
				h.setStatus(rset.getString("STATUS"));
				h.setApproval(rset.getString("APPROVAL"));
				h.setHost_introduce(rset.getString("HOST_INTRODUCE"));
				list.add(h);
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

	public ArrayList<Host> adminSearchHostNameList(Connection conn, String input) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSearchHostNameList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+input+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Host h = new Host();
				h.setHost_no(rset.getInt("HOST_NO"));
				h.setHost_email(rset.getString("HOST_EMAIL"));
				h.setHost_sName(rset.getString("HOST_SNAME"));
				h.setHost_name(rset.getString("HOST_NAME"));
				h.setHost_phone(rset.getString("HOST_PHONE"));
				h.setLike_count(rset.getInt("LIKE_COUNT"));
				h.setReport_count(rset.getInt("REPORT_COUNT"));
				h.setEnroll_date(rset.getDate("ENROLL_DATE"));
				h.setStatus(rset.getString("STATUS"));
				h.setApproval(rset.getString("APPROVAL"));
				h.setHost_introduce(rset.getString("HOST_INTRODUCE"));
				list.add(h);
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
	/////////////////////////////from pak 10/05/////////////////////////////////////////////
	/**호스트 회원가입
	 * @param conn
	 * @param ho
	 * @return
	 */
	public int signHost(Connection conn, Host ho) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("signHost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ho.getHost_email());
			pstmt.setString(2, ho.getHost_pw());
			pstmt.setString(3, ho.getRn());
			pstmt.setString(4, ho.getHost_sName());
			pstmt.setString(5, ho.getHost_name());
			pstmt.setString(6, ho.getHost_phone());
			pstmt.setString(7, ho.getHost_accountName());
			pstmt.setString(8, ho.getBank_name());
			pstmt.setString(9, ho.getAccount());
			pstmt.setString(10,ho.getHost_introduce());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

		

	/**이메일 체크
	 * @param conn
	 * @param host_email
	 * @return
	 */
	public int emailCheck(Connection conn, String host_email) {
		
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("emailCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, host_email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				result = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
		
		
	}
	
	public Host loginHost(Connection conn, String email, String pw) {
		
		Host h = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("loginHost");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				h = new Host(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getDate(13),
						rs.getDate(14),
						rs.getString(15),
						rs.getString(16),
						rs.getString(17),
						rs.getString(18)
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return h;
	}

	public int updateHost(Connection conn, Host h) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateHost");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, h.getHost_sName());
			ps.setString(2, h.getHost_phone());
			ps.setString(3, h.getBank_name());
			ps.setString(4, h.getAccount());
			ps.setString(5, h.getHost_introduce());
			ps.setString(6, h.getHost_image());
			ps.setString(7, h.getHost_email());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public Host selectHost(Connection conn, String string) {
		
		Host selectH = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectHost");
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, string);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				selectH = new Host(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getDate(13),
						rs.getDate(14),
						rs.getString(15),
						rs.getString(16),
						rs.getString(17),
						rs.getString(18)
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return selectH;
	}

	///////////////////////////////////from rin 10/05//////////////////////////////////
	
	
	public String findID(Connection conn, String hostName, String hostPhone) {
		
		String findID = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findID");
		
		System.out.println("HOSTDAO"+ hostName + hostPhone);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hostName);
			pstmt.setString(2, hostPhone);
			
			rset = pstmt.executeQuery();
			
		if(rset.next()) {
			findID = rset.getString("HOST_EMAIL");
		} 
		System.out.println(findID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return findID;
	}

	public int findPwd(Connection conn, String hostName, String hostEmail, String hostPhone) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hostEmail);
			pstmt.setString(2, hostName);
			pstmt.setString(3, hostPhone);
			
			rset = pstmt.executeQuery();
			
			
			System.out.println("dao" + hostEmail + hostName + hostPhone);
			
			if(rset.next()) {
				result = rset.getInt(1);
				System.out.println(result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
	
		return result;
	}
//////////////////////////from rin 10/07///////////////////////////////////////
	public String selectChangeHostPw(Connection conn, int host_no) {
		// TODO Auto-generated method stub
		//Host host = new Host();
		String userPw = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectChangeHostPw");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, host_no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userPw = rset.getString("HOST_PW");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(userPw);
		return userPw;
	}

	public int updateHostPwAdmin(Connection conn, int hostNo, String newPw) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateHostPwAdmin");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, hostNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	///////////////////////////////from pak 10/07////////////////////////////

	public ArrayList<Host> adminSelectCalHost(Connection conn, String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectCalHost");
		
			try {
				for(String s : arr) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(s));
				rset = pstmt.executeQuery();
				if(rset.next()) {
					Host h = new Host();
					h.setHost_no(rset.getInt("HOST_NO"));
					h.setHost_accountName(rset.getString("HOST_ACCOUNTNAME"));
					h.setBank_name(rset.getString("BANK_NAME"));
					h.setAccount(rset.getString("ACCOUNT"));
					h.setHost_name(rset.getString("TRIBY_TITLE"));
					h.setLike_count(rset.getInt("TRIBY_OP_NO"));
					h.setReport_count(rset.getInt("C_SUM"));
					list.add(h);
				}
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return list;
	}

	public ArrayList<Host> adminSelectWaitHostList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Host> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectWaitHostList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Host h = new Host();
				h.setHost_no(rset.getInt("HOST_NO"));
				h.setHost_accountName(rset.getString("HOST_ACCOUNTNAME"));
				h.setBank_name(rset.getString("BANK_NAME"));
				h.setAccount(rset.getString("ACCOUNT"));
				h.setHost_name(rset.getString("TRIBY_TITLE"));
				h.setLike_count(rset.getInt("TRIBY_OP_NO"));
				//h.setReport_count(rset.getInt("CAL_SUM"));
				h.setApproval(rset.getString("STATUS"));
				list.add(h);
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
	//////////////from pak 10/10

	public Host mainHostDetail(Connection conn, int hNo) {
		Host h=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mainHostDetail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				h=new Host();
				h.setHost_no(rset.getInt(1));
				h.setHost_sName(rset.getString(2));
				h.setHost_introduce(rset.getString(3));
				h.setHost_image(rset.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return h;
	}

	public String mainHostTribyCount(Connection conn, int hNo) {
		String n=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mainHostTribyCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				n=rset.getInt(1)+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public String mainHostReviewCount(Connection conn, int hNo) {
		String n=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mainHostReviewCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				n=rset.getInt(1)+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public String mainHostLikeCount(Connection conn, int hNo) {
		String n=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mainHostLikeCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				n=rset.getInt(1)+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public ArrayList<ThumbnailTriby> loadHostTribyList(Connection conn, int hNo, int page) {
		ArrayList<ThumbnailTriby> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loadHostTribyList");
		int startRow=(page-1)*9+1;
		int endRow=startRow+9-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ThumbnailTriby(rset.getInt(2),
						rset.getInt(3),
						rset.getString(4),
						rset.getInt(5),
						0,
						rset.getString(6)
						,0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<MyReview> loadHostReviewList(Connection conn, int hNo, int page) {
		ArrayList<MyReview> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loadHostReviewList");
		int startRow=(page-1)*5+1;
		int endRow=startRow+5-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MyReview(rset.getInt(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12)
						,rset.getString(13),rset.getString(14),rset.getString(15)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int loadHostTribyListCount(Connection conn, int hNo) {
		int n=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loadHostTribyListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				n=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public int loadHostReviewListCount(Connection conn, int hNo) {
		int n=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loadHostReviewListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				n=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}
	
	public int thisMTriby(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("thisMTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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
		
		//System.out.println(result);
		return result;
	}

	public int allTriby(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("allTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int ReviewCountH(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("ReviewCountH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int ReviewSumH(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("ReviewSumH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int qnaCountH(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("qnaCountH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int qnaCountY(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("qnaCountY");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int thisMsales(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("thisMsales");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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

	public int allSales(Connection conn, Host loginHost) {
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("allSales");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginHost.getHost_no());
			
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
	
		public int updatePwd(Connection conn, String hostEmail, String newPwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println(hostEmail + newPwd);
		String sql = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPwd);
			pstmt.setString(2, hostEmail);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
