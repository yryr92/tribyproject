package com.triby.triby.model.dao;

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
import com.triby.option.model.vo.Option;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.vo.Triby;

public class TribyDao {
	
	private Properties prop = new Properties();
	
	public TribyDao () {
		
		String fileName = TribyDao.class.getResource("/com/triby/sql/triby/triby-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int insertTriby(Connection conn, Triby tr) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tr.gettTitle());
			ps.setString(2, tr.gettContent());
			ps.setString(3, tr.gettContent1());
			ps.setString(4, tr.gettContent2());
			ps.setString(5, tr.gettContent3());
			ps.setInt(6, tr.gethNo());
			ps.setString(7, tr.getcId1());
			ps.setString(8, tr.getcId2());
			ps.setString(9, tr.getcId3());
			ps.setString(10, tr.getAddress());
			ps.setInt(11, tr.gettPrice());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int insertImage(Connection conn, ArrayList<Image> list) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertImage");
		
		try {
			
			for(int i=0; i<list.size(); i++) {
				
				Image img = list.get(i);
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, img.getiName());
				ps.setString(2, img.getiSrc());
				ps.setInt(3, img.getiLev());
				
				result += ps.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public ArrayList<Triby> selectListH(Connection conn, int hNo) {
		
		ArrayList<Triby> tList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectListH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Triby tr = new Triby();
				tr.settNo(rs.getInt("triby_no"));
				tr.settTitle(rs.getString("triby_title"));
				tr.setAppoval_status(rs.getString("approval_status"));
				tr.settPrice(rs.getInt("triby_price"));
				
				tList.add(tr);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return tList;
	}

	public ArrayList<Image> selectImgListH(Connection conn, int hNo) {
		
		ArrayList<Image> iList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectImgListH");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Image img = new Image();
				img.setiName(rs.getString("img_name"));
				img.settNo(rs.getInt("triby_no"));
				
				iList.add(img);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return iList;
	}

	public Triby selectUpdateTriby(Connection conn, int tNo) {
		
		Triby tr = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectUpdateTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				tr = new Triby();
				tr.settTitle(rs.getString("triby_title"));
				tr.settContent(rs.getString("triby_content"));
				tr.settContent1(rs.getString("triby_content1"));
				tr.settContent2(rs.getString("triby_content2"));
				tr.settContent3(rs.getString("triby_content3"));
				tr.setcId1(rs.getString("category_id"));
				tr.setcId2(rs.getString("category_id2"));
				tr.setcId3(rs.getString("category_id3"));
				tr.setAddress(rs.getString("address"));
				tr.settNo(tNo);
				tr.settPrice(rs.getInt("triby_price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return tr;
	}

	public ArrayList<Image> selectImgListT(Connection conn, int tNo) {
		
		ArrayList<Image> iList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectImgListT");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Image img = new Image();
				img.settNo(tNo);
				img.setiLev(rs.getInt("img_lev"));
				img.setiName(rs.getString("img_name"));
				
				iList.add(img);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return iList;
	}

	public int updateTriby(Connection conn, Triby tr) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tr.gettTitle());
			ps.setString(2, tr.gettContent());
			ps.setString(3, tr.gettContent1());
			ps.setString(4, tr.gettContent2());
			ps.setString(5, tr.gettContent3());
			ps.setString(6, tr.getcId1());
			ps.setString(7, tr.getcId2());
			ps.setString(8, tr.getcId3());
			ps.setString(9, tr.getAddress());
			ps.setInt(10, tr.gettPrice());
			ps.setInt(11, tr.gettNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int updateImage(Connection conn, ArrayList<Image> list) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		
		
		return 0;
	}

	public int insertOption(Connection conn, Option op, ArrayList<String> days, ArrayList<String> times) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertOption");
		
		try {
			
			for(int i=0; i<days.size(); i++) {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, op.gettId());
				ps.setInt(2, op.getPerson_min());
				ps.setInt(3, op.getPerson_max());
				ps.setString(4, days.get(i));
				ps.setString(5, times.get(i));
				
				result += ps.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public ArrayList<Option> selectOption(Connection conn, int tNo) {
		
		ArrayList<Option> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOption");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Option op = new Option();
				op.setoNo(rs.getInt("triby_op_no"));
				op.settId(rs.getInt("triby_id"));
				op.setPerson_min(rs.getInt("person_min"));
				op.setPerson_max(rs.getInt("person_max"));
				op.settAttend(rs.getInt("triby_attend"));
				op.settDay(rs.getString("tday"));
				op.settTime(rs.getString("ttime"));
				op.setStatus(rs.getString("status"));
				
				list.add(op);
				
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

	public ArrayList<Triby> selectListH(Connection conn, int hNo, int status, PageInfo pi) {
		
		ArrayList<Triby> tList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		
		if(status == 0) {
			sql = prop.getProperty("selectListH0");
		} else if(status == 1) {
			sql = prop.getProperty("selectListH1");
		} else {
			sql = prop.getProperty("selectListH2");
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
				Triby tr = new Triby();
				tr.settNo(rs.getInt("triby_no"));
				tr.settTitle(rs.getString("triby_title"));
				tr.setAppoval_status(rs.getString("approval_status"));
				tr.settPrice(rs.getInt("triby_price"));
				
				tList.add(tr);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return tList;
	}

	public ArrayList<Image> selectImgListH(Connection conn, int hNo, int status, PageInfo pi) {
		
		ArrayList<Image> iList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		if(status == 0) {
			sql = prop.getProperty("selectImgListH0");
		} else if(status == 1) {
			sql = prop.getProperty("selectImgListH1");
		} else {
			sql = prop.getProperty("selectImgListH2");
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
				Image img = new Image();
				img.setiName(rs.getString("img_name"));
				img.settNo(rs.getInt("triby_no"));
				
				iList.add(img);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return iList;
	}

	public int deleteTriby(Connection conn, int tNo) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("deleteTriby");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int endOption(Connection conn, int tNo, int oNo) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("endOption");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tNo);
			ps.setInt(2, oNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
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
	/////////////////////start from pak 10/09//////////////////////	
	public ArrayList<Triby> adminSelectDisTribyList(Connection conn, PageInfo pi) {

	ArrayList<Triby> list = new ArrayList<>();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("adminSelectDisTribyList");

	try {
	pstmt = conn.prepareStatement(sql);
	int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
	int endRow = startRow + pi.getBoardLimit()-1;
	pstmt.setInt(1, startRow);
	pstmt.setInt(2, endRow);
	rset = pstmt.executeQuery();
	while(rset.next()) {
		Triby t = new Triby();
		t.settNo(rset.getInt("TRIBY_NO"));
		t.settTitle(rset.getString("TRIBY_TITLE"));
		t.setcId1(rset.getString("HOST_NAME"));
		t.setcId2(rset.getString("APPROVAL"));
		t.settContent1(rset.getString("HOST_PHONE"));
		t.settContent2(rset.getString("HOST_EMAIL"));
		t.setAppoval_status(rset.getString("APPROVAL_STATUS"));
		t.setTriby_date(rset.getDate("TRIBY_DATE"));
		list.add(t);
/*	list.add(new Triby(rset.getInt("TRIBY_NO"),
	   rset.getString("TRIBY_TITLE"),
	   rset.getString("TRIBY_CONTENT"),
	   rset.getString("TRIBY_CONTENT1"),
	   rset.getString("TRIBY_CONTENT2"),
	   rset.getString("TRIBY_CONTENT3"),
	   rset.getInt("HOST_NO"),
	   rset.getString("CATEGORY_ID"),
	   rset.getString("CATEGORY_ID2"),
	   rset.getString("CATEGORY_ID3"),
	   rset.getString("ADDRESS"),
	   rset.getString("APPROVAL_STATUS"),
	   rset.getInt("TRIBY_LIKES"),
	   rset.getDate("TRIBY_DATE"),
	   rset.getInt("TRIBY_VIEWCOUNT"),
	   rset.getInt("TRIBY_PRICE")));*/
	}
	} catch (SQLException e) {
	//TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	close(rset);
	close(pstmt);
	}
	return list;
	}

	public int adminGetListCount(Connection conn) {
	//TODO Auto-generated method stub
	int listCount = 0;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("adminGetListCount");

	try {
	pstmt = conn.prepareStatement(sql);
	rset = pstmt.executeQuery();
	if(rset.next()) {
	listCount= rset.getInt("COUNT(*)");
	}
	} catch (SQLException e) {
	//TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	close(rset);
	close(pstmt);
	}
	return listCount;
	}

	public int adminUpdateApproval(Connection conn, int tNo) {
	//TODO Auto-generated method stub
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminUpdateApproval");

	try {
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,tNo);
	result = pstmt.executeUpdate();
	} catch (SQLException e) {
	//TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	close(pstmt);
	}
	return result;
	}
	////////////////////////////end pak 10/09/////////////////////////////////	
	///////////////////////////start from pak 10/12
	public Triby adminSelectTriby(Connection conn, int tNo) {
		// TODO Auto-generated method stub
		Triby t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectTriby");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				t = new Triby();
				t.settNo(rset.getInt("TRIBY_NO"));
				t.setAppoval_status(rset.getString("HOST_NAME"));
				t.settTitle(rset.getString("TRIBY_TITLE"));
				t.setcId1(rset.getString("CATEGORY_NAME"));
				//from pak 10/14
				t.setcId2(rset.getString("CATEGORY_NAME2"));
				t.setcId3(rset.getString("CATEGORY_NAME3"));
				//end pak 10/14
				t.setAddress(rset.getString("ADDRESS"));
				t.settPrice(rset.getInt("TRIBY_PRICE"));
				t.settContent1(rset.getString("TRIBY_CONTENT1"));
				t.settContent2(rset.getString("TRIBY_CONTENT2"));
				t.settContent3(rset.getString("TRIBY_CONTENT3"));
				t.settContent(rset.getString("TRIBY_CONTENT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return t;
	}
	
	///////////////end from pak 10/12
	
	
}
