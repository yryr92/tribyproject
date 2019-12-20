package com.triby.notice.model.dao;

import static com.triby.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.triby.notice.model.vo.Notice;
import com.triby.common.PageInfo;
import com.triby.faq.model.vo.Faq;

public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		String fileName = NoticeDao.class.getResource("/com/triby/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectNoticeListAdmin(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeListAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;
		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
		
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getDate("NOTICE_DATE"),
									rset.getString("NOTICE_STATUS")));
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

	public Notice selectNoticeAdmin(Connection conn, int nNo) {
		// TODO Auto-generated method stub
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeAdmin");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getDate("NOTICE_DATE"),
									rset.getString("NOTICE_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return notice;
	}

	public int updateNotice(Connection conn, Notice notice) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getnCategory());
			pstmt.setString(2, notice.getnTitle());
			pstmt.setString(3, notice.getnContent());
			pstmt.setInt(4, notice.getnNo());
			pstmt.setString(5,notice.getnStatus());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertNotice(Connection conn, Notice notice) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,notice.getnCategory());
			pstmt.setString(2, notice.getnTitle());
			pstmt.setString(3, notice.getnContent());
			pstmt.setString(4, notice.getnStatus());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int nNo) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> selectNoticeListSelectedAdmin(Connection conn, PageInfo pi, String selected) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectedNoticeListSelectedAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;

			pstmt.setString(1,selected);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
						rset.getString("NOTICE_CATEGORY"),
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getDate("NOTICE_DATE"),
						rset.getString("NOTICE_STATUS")));
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

	public ArrayList<Notice> selectNoticeListSecretAdmin(Connection conn, PageInfo pi, String secret) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeListSecretAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;

			pstmt.setString(1,secret);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
						rset.getString("NOTICE_CATEGORY"),
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getDate("NOTICE_DATE"),
						rset.getString("NOTICE_STATUS")));
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
/////////////////////////from PAK 10/01//////////////////////////	

	public ArrayList<Notice> adminSearchNoticeList(Connection conn, PageInfo pi, String title) {
		// TODO Auto-generated method stub
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSearchNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() -1;
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
						rset.getString("NOTICE_CATEGORY"),
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getDate("NOTICE_DATE"),
						rset.getString("NOTICE_STATUS")));
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

	public int adminGetNoticeListCount(Connection conn) {
		// TODO Auto-generated method stub
		int selectedListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetSelectedListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "공지");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				selectedListCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return selectedListCount;
	}

	public int adminGetEventListCount(Connection conn) {
		// TODO Auto-generated method stub
		int selectedListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetSelectedListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "이벤트");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				selectedListCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectedListCount;
	}

	public int adminGetHostListCount(Connection conn) {
		// TODO Auto-generated method stub
		int selectedListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetSelectedListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "호스트");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				selectedListCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectedListCount;
	}

	public int adminGetSecretListCount(Connection conn) {
		// TODO Auto-generated method stub
		int selectedListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetSecretListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				selectedListCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectedListCount;
	}

	public int adminGetSearchListCount(Connection conn, String title) {
		// TODO Auto-generated method stub
		int searchListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminGetSearchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				searchListCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.err.println("dao: "+searchListCount);
		System.err.println("title: "+title);
		return searchListCount;
	}
	
	/////////////////////from pak 10/05/////////////////////////////////////////////
public ArrayList<Notice> selectListh(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectListh");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(
						rs.getInt("notice_no"),
						rs.getString("notice_category"),
						rs.getString("notice_title"),
						rs.getString("notice_content"),
						rs.getDate("notice_date"),
						rs.getString("notice_status")
						));
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

	public int getListhCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("getListhCount");
		
		try {
			ps = conn.prepareStatement(sql);
			
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
/////////////////////////////////from rin 10/05///////////////////////////////////

	public ArrayList<Notice> loadMainNotice(Connection conn, int page) {
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("loadMainNotice");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (page - 1) * 20 + 1;
			int endRow = startRow + 20 - 1;
			
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(
						rs.getInt("notice_no"),
						rs.getString("notice_category"),
						rs.getString("notice_title"),
						rs.getString("notice_content"),
						rs.getString("notice_status"),
						rs.getString("notice_date")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return list;
	}

	public ArrayList<Notice> loadCategoryNotice(Connection conn, String category, int page) {
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("loadCategoryNotice");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (page - 1) * 20 + 1;
			int endRow = startRow + 20 - 1;
			ps.setString(1, category);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(
						rs.getInt("notice_no"),
						rs.getString("notice_category"),
						rs.getString("notice_title"),
						rs.getString("notice_content"),
						rs.getString("notice_status"),
						rs.getString("notice_date")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return list;
	}

	public int mainNoticeCount(Connection conn, String category) {
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("mainNoticeCategoryCount");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,category);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return listCount;
	}

	public int mainNoticeCount(Connection conn) {
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("mainNoticeCount");
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return listCount;
	}

	public String loadMainNoticeContent(Connection conn, int nNo) {
		String str = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("loadMainNoticeContent");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,nNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				str = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return str;
	}

	public ArrayList<Faq> loadMainFaqList(Connection conn, int page) {
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("loadMainFaqList");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (page - 1) * 20 + 1;
			int endRow = startRow + 20 - 1;
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Faq(rs.getInt(1),rs.getString(2),rs.getString(3)
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return list;
	}

	public ArrayList<Faq> loadMainFaqList(Connection conn, String key, int page) {
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str="%"+key+"%";
		String sql = prop.getProperty("loadMainFaqSearch");
		
		try {
			ps = conn.prepareStatement(sql);
			
			int startRow = (page - 1) * 20 + 1;
			int endRow = startRow + 20 - 1;
			ps.setString(1, str);
			ps.setString(2, str);
			ps.setInt(3, startRow);
			ps.setInt(4, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Faq(rs.getInt(1),rs.getString(2),rs.getString(3)
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return list;
	}

	public int loadMainFaqCount(Connection conn) {
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("loadMainFaqCount");
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return listCount;
	}

	public int loadMainFaqCount(Connection conn, String key) {
		int listCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str="%"+key+"%";
		String sql = prop.getProperty("loadMainFaqCountSearch");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, str);
			ps.setString(2, str);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return listCount;
	}
	
	public ArrayList<Notice> selectMnlist(Connection conn) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMnlist");
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Notice no = new Notice();
				no.setnNo(rs.getInt("notice_no"));
				no.setnCategory(rs.getString("notice_category"));
				no.setnDate(rs.getDate("notice_date"));
				no.setnTitle(rs.getString("notice_title"));
				
				list.add(no);
				
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
}

