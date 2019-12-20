package com.triby.member.model.dao;

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
import com.triby.coupon.model.vo.Coupon;
import com.triby.likeHost.model.vo.Likehost;
import com.triby.member.model.vo.Member;
import com.triby.member.model.vo.MyTriby;
import com.triby.qnaHost.model.vo.QnA;
import com.triby.review.model.vo.MyReview;
import com.triby.triby.model.vo.ThumbnailTriby;

public class MemberDao {

	private Properties prop = new Properties();
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/com/triby/sql/Member/member-query.properties").getPath();
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
	public ArrayList<Member> adminSelectMember(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
					m.setuNo(rset.getInt("USER_NO"));
					m.setEmail(rset.getString("USER_EMAIL"));
					m.setName(rset.getString("USER_NAME"));
					m.setGender(rset.getString("USER_GENDER"));
					m.setBirth(rset.getInt("USER_BIRTH")+"");
					m.setPhone(rset.getString("USER_PHONE"));
					m.setCategory(rset.getString("USER_CATEGORY"));
					m.setReportedCount(rset.getInt("USER_REPORTED_COUNT"));
					m.setRegisterDate(rset.getDate("USER_REGISTER_DATE")+"");
					m.setStatus(rset.getString("USER_STATUS"));
					list.add(m);
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
///////////////////from PAK 10/01////////////////////////////////////////////////////
	public ArrayList<Member> adminSelectMemberStatus(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectMemberStatus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setuNo(rset.getInt("USER_NO"));
				m.setEmail(rset.getString("USER_EMAIL"));
				m.setName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("USER_GENDER"));
				m.setBirth(rset.getInt("USER_BIRTH")+"");
				m.setPhone(rset.getString("USER_PHONE"));
				m.setCategory(rset.getString("USER_CATEGORY"));
				m.setReportedCount(rset.getInt("USER_REPORTED_COUNT"));
				m.setRegisterDate(rset.getDate("USER_REGISTER_DATE")+"");
				m.setStatus(rset.getString("USER_STATUS"));
				list.add(m);
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
	public ArrayList<Member> adminSearchUserNoList(Connection conn, String input) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSearchUserNoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+input+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setuNo(rset.getInt("USER_NO"));
				m.setEmail(rset.getString("USER_EMAIL"));
				m.setName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("USER_GENDER"));
				m.setBirth(rset.getInt("USER_BIRTH")+"");
				m.setPhone(rset.getString("USER_PHONE"));
				m.setCategory(rset.getString("USER_CATEGORY"));
				m.setReportedCount(rset.getInt("USER_REPORTED_COUNT"));
				m.setRegisterDate(rset.getDate("USER_REGISTER_DATE")+"");
				m.setStatus(rset.getString("USER_STATUS"));
				list.add(m);
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
	public ArrayList<Member> adminSearchUserNameList(Connection conn, String input) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSearchUserNameList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+input+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setuNo(rset.getInt("USER_NO"));
				m.setEmail(rset.getString("USER_EMAIL"));
				m.setName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("USER_GENDER"));
				m.setBirth(rset.getInt("USER_BIRTH")+"");
				m.setPhone(rset.getString("USER_PHONE"));
				m.setCategory(rset.getString("USER_CATEGORY"));
				m.setReportedCount(rset.getInt("USER_REPORTED_COUNT"));
				m.setRegisterDate(rset.getDate("USER_REGISTER_DATE")+"");
				m.setStatus(rset.getString("USER_STATUS"));
				list.add(m);	
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
	//////////////////////////////from pak 10/05//////////////////////////////////////
	/** 회원가입을 위한 메소드
	 * @param conn
	 * @param mem
	 * @return result
	 */
	public int signupMember(Connection conn, Member mem) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("signupMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getEmail()); 
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getGender());
			pstmt.setString(5, mem.getPhone());
			pstmt.setString(6, mem.getCategory());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 로그인을 위한 메소드
	 * @param conn
	 * @param user_email
	 * @param user_pw
	 * @return
	 */
	public Member loginMember(Connection conn, String user_email, String user_pw) {
		
		Member loginUser =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_email);
			pstmt.setString(2, user_pw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("USER_NO"),
									   rset.getString("USER_EMAIL"),
									   rset.getString("USER_PW"),
									   rset.getString("USER_NAME"),
									   rset.getString("USER_GENDER"),
									   rset.getString("USER_BIRTH")+"",
									   rset.getString("USER_PHONE"),
									   rset.getString("USER_PROFILE"),
									   rset.getString("USER_CATEGORY"),
									   rset.getInt("USER_REPORTED_COUNT"),
									   rset.getString("USER_REGISTER_DATE")+"",
									   rset.getString("MODIFY_DATE")+"",
								       rset.getString("USER_STATUS"),
								       rset.getString("ARALM_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}

	public int emailCheck(Connection conn, String user_email) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("emailCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_email);
			
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

	public Member findUser(Connection conn, String userName, String userPhone) {
		
		Member findUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findUser");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
			
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return findUser;
		
	}
	///////////////////////from min 10/05////////////////////////////////////////////////////


public String findID(Connection conn, String userName, String userPhone) {
		
		String findID = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findID");
		
		System.out.println("USERdao"+userName+userPhone);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				findID = rset.getString("USER_EMAIL");	
			}
			System.out.println(findID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return findID;
		
	}

public int findPwd(Connection conn, String userEmail, String userName, String userPhone) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("findPwd");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userEmail);
		pstmt.setString(2, userName);
		pstmt.setString(3,userPhone);
		
		rset = pstmt.executeQuery();
		
		
		
		System.out.println("dao" + userEmail+ userName + userPhone);
		
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
public Member userProfile(Connection conn,Member m) {
	Member user=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("userProfile");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		
		rset=pstmt.executeQuery();
		if(rset.next()) {
			user = new Member(rset.getInt("USER_NO"),
					   rset.getString("USER_EMAIL"),
					   rset.getString("USER_PW"),
					   rset.getString("USER_NAME"),
					   rset.getString("USER_GENDER"),
					   rset.getString("USER_BIRTH")+"",
					   rset.getString("USER_PHONE"),
					   rset.getString("USER_PROFILE"),
					   rset.getString("USER_CATEGORY"),
					   rset.getInt("USER_REPORTED_COUNT"),
					   rset.getString("USER_REGISTER_DATE")+"",
					   rset.getString("MODIFY_DATE")+"",
				       rset.getString("USER_STATUS"),
				       rset.getString("ARALM_STATUS"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return user;
	
}
public int couponCount(Connection conn, Member m) {

	int count=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("couponCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		
		rset=pstmt.executeQuery();
		if(rset.next()) {
			count=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return count;
}
public ArrayList<ThumbnailTriby> selectLikeTribyList(Connection conn, Member m, int page) {
	ArrayList<ThumbnailTriby> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectLikeTribyList");
	int startRow=(page-1)*9+1;
	int endRow=startRow+9-1;
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, endRow);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new ThumbnailTriby(rset.getInt(2),
									rset.getInt(3),
									rset.getString(4),
									rset.getInt(5),
									rset.getInt(6),
									rset.getString(7)
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
public int myLikeTribyCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("myLikeTribyCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
	
}
public ArrayList<Likehost> selectLikeHostList(Connection conn, Member m, int page) {
	ArrayList<Likehost> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectLikeHostList");
	int startRow=(page-1)*20+1;
	int endRow=startRow+20-1;
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, endRow);
		
		rset=pstmt.executeQuery();
		while(rset.next()) {
			Likehost lh=new Likehost();
			lh.setuNo(rset.getInt(2));
			lh.sethNo(rset.getInt(3));
			lh.sethName(rset.getString(4));
			lh.sethImg(rset.getString(5));
			list.add(lh);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}
public int hostTribyCount(Connection conn, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("hostTribyCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
				
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
	
}
public int hostReviewCount(Connection conn, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("hostReviewCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public int hostLikeCount(Connection conn, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("hostLikeCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
	
}
public int myLikeHostCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("myLikeHostCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public ArrayList<Coupon> selectMyCouponList(Connection conn, Member m) {
	ArrayList<Coupon> list= new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectMyCouponList");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new Coupon(rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7)));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
	
}
public ArrayList<String> selectCategoryList(Connection conn) {
	ArrayList<String> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectCategoryList");
	try {
		pstmt=conn.prepareStatement(sql);
		rset=pstmt.executeQuery();
		
		while(rset.next()) {
			list.add(rset.getString(1));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}
public int updateMyCategory(Connection conn, Member m, String category) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("updateMyCategory");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, category);
		pstmt.setInt(2, m.getuNo());
		result=pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
	
}
public ArrayList<MyTriby> selectTribyPreList(Connection conn, Member m, int page) {
	ArrayList<MyTriby> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectTribyPreList");
	int startRow=(page-1)*5+1;
	int endRow=startRow+5-1;
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2,startRow);
		pstmt.setInt(3, endRow);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new MyTriby(rset.getInt(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7),rset.getInt(8),rset.getString(9)+"",rset.getString(10),rset.getInt(11),rset.getInt(12),rset.getString(13)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}
public int selectTribyPreListCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectTribyPreListCount");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
	
}
public ArrayList<MyTriby> selectTribyHistoryList(Connection conn, Member m, int page) {
	ArrayList<MyTriby> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectTribyHistoryList");
	int startRow=(page-1)*5+1;
	int endRow=startRow+5-1;
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2,startRow);
		pstmt.setInt(3, endRow);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new MyTriby(rset.getInt(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7),rset.getInt(8),rset.getString(9)+"",rset.getString(10),rset.getInt(11)
						,rset.getInt(12),rset.getString(13)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
	
}
public int selectTribyHistoryListCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectTribyHistoryListCount");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public MyTriby selectReviewTarget(Connection conn, Member m, int pNo) {
	MyTriby triby=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectReviewTarget");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, pNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			triby=new MyTriby(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6),rset.getInt(7),rset.getString(8),rset.getString(9),rset.getInt(10)
					,rset.getInt(11),rset.getString(12));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return triby;
}
public ArrayList<MyReview> selectMyReviewList(Connection conn, Member m, int page) {
	ArrayList<MyReview> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectMyReviewList");
	int startRow=(page-1)*5+1;
	int endRow=startRow+5-1;
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2,startRow);
		pstmt.setInt(3, endRow);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			list.add(new MyReview(rset.getInt(2),
									rset.getInt(3),
									rset.getInt(4),
									rset.getInt(5),
									rset.getInt(6),
									rset.getString(7),
									rset.getString(8),
									rset.getString(9),
									rset.getString(10),
									rset.getString(11),
									rset.getInt(12),
									rset.getString(13),
									rset.getString(14),
									rset.getString(15)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}
public int selectMyReviewListCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectMyReviewListCount");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public String canceledTribySearch(Connection conn, int pNo) {
	String str=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("canceledTribySearch");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pNo);
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
public int tribyCancel(Connection conn, int pNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("tribyCancel");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
	
}
public int removeLikeTriby(Connection conn, Member m, int tNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("removeLikeTriby");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, tNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int addLikeTriby(Connection conn, Member m, int tNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("addLikeTriby");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, tNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int removeLikeHost(Connection conn, Member m, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("removeLikeHost");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, hNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int addLikeHost(Connection conn, Member m, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("addLikeHost");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, hNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int updateProfileImage(Connection conn, Member m, String changeName) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("updateProfileImage");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, changeName);
		pstmt.setInt(2, m.getuNo());
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int updateMyPw(Connection conn, Member m, String pw) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("updateMyPw");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, pw);
		pstmt.setInt(2, m.getuNo());
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public double selectPoint(Connection conn, int hNo) {
	double point=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectPoint");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			point=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return point;
}
public int amIlikeHost(Connection conn, Member m, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("amIlikeHost");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public int decreseTOcount(Connection conn, int pNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("decreseTOcount");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pNo);
		pstmt.setInt(2, pNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
	
}
public int increseHostLikeCount(Connection conn, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("increseHostLikeCount");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
	
}
public int decreseHostLikeCount(Connection conn, int hNo) {
	int result=0;
	PreparedStatement pstmt=null;
	String sql=prop.getProperty("decreseHostLikeCount");		
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		result=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int amIlikeTriby(Connection conn, Member m, int tNo) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("amIlikeTriby");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2, tNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public ArrayList<QnA> selectMyQnaList(Connection conn, Member m, int page) {
	ArrayList<QnA> list=new ArrayList<>();
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("selectMyQnaList");
	int startRow=(page-1)*5+1;
	int endRow=startRow+5-1;
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		pstmt.setInt(2,startRow);
		pstmt.setInt(3, endRow);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			QnA q=new QnA();
			q.setqNo(rset.getInt(2));
			q.sethNo(rset.getInt(3));
			q.setUser_name(rset.getString(4));
			q.setqTitle(rset.getString(5));
			q.setqDate(rset.getString(6));
			q.setqStatus(rset.getString(7));
			q.setqContent(rset.getString(8));// 호스트프사
			list.add(q);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
}
public int myQnaListCount(Connection conn, Member m) {
	int result=0;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("myQnaListCount");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, m.getuNo());
		rset=pstmt.executeQuery();
		if(rset.next()) {
			result=rset.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return result;
}
public QnA loadMyQcontent(Connection conn, int qNo) {
	QnA q=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("loadMyQcontent");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, qNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			q=new QnA();
			q.setqTitle(rset.getString(1));
			q.setqContent(rset.getString(2));
			q.setUser_name(rset.getString(3));
			q.setqAnswer(rset.getString(4));
			q.setaDate(rset.getString(5));
			q.setqStatus(rset.getString(6));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return q;
	
}
public String qnaHostName(Connection conn, int hNo) {
	String str=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String sql=prop.getProperty("qnaHostName");
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hNo);
		rset=pstmt.executeQuery();
		if(rset.next()) {
			str=rset.getString(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return str;
	
}
public int updatePwd(Connection conn, String userEmail, String newPwd) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	System.out.println(userEmail + newPwd);
	String sql = prop.getProperty("updatePwd");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, newPwd);
		pstmt.setString(2, userEmail);
		
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
