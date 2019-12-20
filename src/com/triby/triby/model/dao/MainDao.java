package com.triby.triby.model.dao;

import static com.triby.common.JDBCTemplate.*;

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
import com.triby.member.model.vo.Member;
import com.triby.payment.model.vo.Payment;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.vo.MainDetailRight;
import com.triby.triby.model.vo.MainDetailTriby;
import com.triby.triby.model.vo.MainHostDetail;
import com.triby.triby.model.vo.MainReviewDetail;
import com.triby.triby.model.vo.ThumbnailTriby;
import com.triby.triby.model.vo.Triby;

public class MainDao {
	
	private Properties prop = new Properties();
	
	public MainDao() {
		String fileName = MainDao.class.getResource("/com/triby/sql/main/main-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 1. Hot 트리비 리스트 뽑아 오기
	 * @param conn
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectHList(Connection conn){
		
		ArrayList<ThumbnailTriby> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectHList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ThumbnailTriby(rset.getInt("triby_no"),
											rset.getString("triby_title"),
											rset.getInt("triby_price"),
											rset.getInt("triby_likes"),
											rset.getString("img_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	/**
	 * 2. New 트리비 리스트 뽑아오기
	 * @param conn
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectNlist(Connection conn){
		
		ArrayList<ThumbnailTriby> nlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				nlist.add(new ThumbnailTriby(rset.getInt("triby_no"),
											rset.getString("triby_title"),
											rset.getInt("triby_price"),
											rset.getInt("triby_likes"),
											rset.getString("img_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return nlist;
	}
	
	/**
	 *  3_0. 검색어 트리비 갯수 세기
	 * @param conn
	 * @param search
	 * @return
	 */
	public int searchListCount(Connection conn, String search) {
		
		int sc =0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+search+"%");
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				sc = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sc;
	}
	
	/**
	 * 3. 검색 트리비 리스트 뽑아오기
	 * @param conn
	 * @param search
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchList(Connection conn, String search, PageInfo pi){
		
		ArrayList<ThumbnailTriby> slist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1,"%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				slist.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return slist;
	}
	
	/**
	 * 3_1. 검색 결과 가격순 정렬
	 * @param conn
	 * @param search
	 * @param pi
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchPriceList(Connection conn, String search, PageInfo pi){
		
		ArrayList<ThumbnailTriby> splist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchSlistP");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1,"%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				splist.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return splist;
	}
	
	/**
	 * 3_2.검색 결과 최신순 정렬
	 * @param conn
	 * @param search
	 * @param pi
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchDateList(Connection conn, String search, PageInfo pi){
		
		ArrayList<ThumbnailTriby> sdlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchSlistD");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setString(1,"%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sdlist.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sdlist;
	}
	
	
	/**
	 * 4_1  카테고리 검색 (인기)
	 * @param conn
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectCList(Connection conn, String category) {
		
		ArrayList<ThumbnailTriby> clist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchClistH");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+category+"%");
			pstmt.setString(2, "%"+category+"%");
			pstmt.setString(3, "%"+category+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				clist.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}
	
	/**
	 * 4_2 카테고리 검색 (조회수)
	 * @param conn
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectCListv(Connection conn, String category) {
		
		ArrayList<ThumbnailTriby> clistV = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchClistV");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+category+"%");
			pstmt.setString(2, "%"+category+"%");
			pstmt.setString(3, "%"+category+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				clistV.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clistV;
	}
	
	/**
	 * 4_3. 카테고리 겁색(신규)
	 * @param conn
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectClistN(Connection conn, String category){
		
		ArrayList<ThumbnailTriby> clistN = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchClistV");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+category+"%");
			pstmt.setString(2, "%"+category+"%");
			pstmt.setString(3, "%"+category+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				clistN.add(new ThumbnailTriby(rset.getInt("triby_no"),
											 rset.getString("triby_title"),
											 rset.getInt("triby_price"),
											 rset.getInt("triby_likes"),
											 rset.getString("img_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clistN;
	}
	
	/**
	 * 5_1. 디테일 뷰에서 쓸 트리비 정보
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainDetailTriby> detailTriby(Connection conn, int tNo){
		
		ArrayList<MainDetailTriby> dt = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailtriby");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dt.add(new MainDetailTriby(rset.getInt("TRIBY_NO"),
											 rset.getString("TRIBY_TITLE"),
											 rset.getInt("TRIBY_PRICE"),
											 rset.getInt("TRIBY_LIKES"),
											 rset.getString("IMG_NAME"),
											 rset.getString("TRIBY_CONTENT"),
											 rset.getString("TRIBY_CONTENT1"),
											 rset.getString("TRIBY_CONTENT2"),
											 rset.getString("TRIBY_CONTENT3"),
											 rset.getString("ADDRESS"),
											 rset.getString("CATEGORY_ID")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return dt;
	}
	
	/**
	 * 5_2. 디테일 뷰에서 쓸 호스트 프로필
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainHostDetail> detailHost(Connection conn, int tNo){
		ArrayList<MainHostDetail> dh = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailhost");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dh.add(new MainHostDetail(rset.getInt("HOST_NO"),
											 rset.getString("HOST_SNAME"),
											 rset.getString("HOST_INTRODUCE"),
											 rset.getString("HOST_IMAGE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return dh;
	}
	
	/**
	 * 5_3. 디테일 뷰에서 쓸 리뷰 상위 1개
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainReviewDetail> detailReview(Connection conn, int tNo){
		
		ArrayList<MainReviewDetail> dv = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailreview");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dv.add(new MainReviewDetail(rset.getInt("HOST_NO"),
											 rset.getString("USER_NAME"),
											 rset.getDouble("REVIEW_POINT"),
											 rset.getString("REVIEW_CONTENT"),
											 rset.getString("REVIEW_DATE")));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(sql);
		System.out.println(dv);
		return dv;
	}
	
	/**
	 * 5_4. 디테일 뷰에서 쓸 옵션
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainDetailRight> detailRight(Connection conn, int tNo){
		ArrayList<MainDetailRight> dr = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailright");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dr.add(new MainDetailRight(rset.getInt("TRIBY_OP_NO"),
											 rset.getInt("PERSON_MIN"),
											 rset.getInt("PERSON_MAX"),
											 rset.getInt("TRIBY_ATTEND"),
											 rset.getString("TDAY"),
											 rset.getString("TTIME")));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return dr;
	}
	
	/**
	 * 5_5. 디테일 뷰에서 other 트리비
	 * @return
	 */
	public ArrayList<ThumbnailTriby> otherTriby(Connection conn) {
		ArrayList<ThumbnailTriby> ot = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("otherTriby");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ot.add(new ThumbnailTriby(rset.getInt("triby_no"),
											rset.getString("triby_title"),
											rset.getInt("triby_price"),
											rset.getInt("triby_likes"),
											rset.getString("img_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ot;
	}
	
	/**
	 * 6. 결제할때 사용할 트리비 썸네일 1개만 필요
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public ArrayList<ThumbnailTriby> paymentTriby(Connection conn, int tNo){
		
		ArrayList<ThumbnailTriby> pt = new ArrayList<>();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentTriby");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				pt.add(new ThumbnailTriby(rset.getInt("triby_no"),
										  rset.getString("triby_title"),
										  rset.getInt("triby_price"),
										  rset.getInt("triby_likes"),
										  rset.getString("img_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return pt;
	}
	
	/**
	 * 7. 쿠폰 선택
	 * @param conn
	 * @param m
	 * @return
	 */
	public ArrayList<Coupon> couponUse(Connection conn, int m) {
	
		ArrayList<Coupon> uC = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("couponList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, m);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				uC.add(new Coupon(rset.getInt("coupon_no"),
								  rset.getString("coupon_name"),
								  rset.getInt("discount_rate"),
								  rset.getString("coupon_start"),
								  rset.getString("coupon_end"),
								  rset.getString("coupon_status"),
								  rset.getInt("user_no")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return uC;
	}
	
	/**
	 *  8. 결제 정보 등록
	 * @param uNo		// 사용자 번호
	 * @param oNo		// 옵션 번호
	 * @param tPayment	// 최종 결제 금액
	 * @param payInfo	// 결제 정보
	 * @param dic		// 할인금액
	 * @return
	 */
	public int payInfo(Connection conn, Payment p){
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("paymentInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getUno());
			pstmt.setInt(2, p.gettONo());
			pstmt.setInt(3, p.getpFinal());
			pstmt.setString(4, p.getpInfo());
			pstmt.setInt(5, p.getpDis());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	
	/**
	 * 9. 사용한 쿠폰 사용 완료 처리
	 * @param conn
	 * @param cNo
	 * @return
	 */
	public int payCoupon(Connection conn, int cNo){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("couponUse");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, cNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}	
		return result;
	}
	
	/**
	 * 10. option 현재원 증가
	 * @param conn
	 * @param person
	 * @param oNo
	 * @return
	 */
	public int payCoupon(Connection conn, int person, int oNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("paymentPerson");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, person);
			pstmt.setInt(2, oNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}	
		return result;
	}
	
	/**
	 * 11. 좋아요 갯수 증가
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public int tribyLike(Connection conn, int tNo) {
		int result2 = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("tribyLike");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, tNo);
			
			result2 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}	
		return result2;
	}
	
	/**
	 * 12. 좋아요 갯수 감소
	 * @param conn
	 * @param tNo
	 * @return
	 */
	public int tribyRemove(Connection conn, int tNo) {
		int result2 = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("tribyRemove");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, tNo);
			
			result2 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}	
		return result2;
	}
	
}














