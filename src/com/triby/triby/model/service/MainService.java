package com.triby.triby.model.service;

import static com.triby.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.common.PageInfo;
import com.triby.coupon.model.vo.Coupon;
import com.triby.member.model.vo.Member;
import com.triby.payment.model.vo.Payment;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.dao.MainDao;
import com.triby.triby.model.vo.MainDetailRight;
import com.triby.triby.model.vo.MainDetailTriby;
import com.triby.triby.model.vo.MainHostDetail;
import com.triby.triby.model.vo.MainReviewDetail;
import com.triby.triby.model.vo.ThumbnailTriby;
import com.triby.triby.model.vo.Triby;

/**
 * @author User
 *
 */
public class MainService {

	/**
	 *  1. Hot Triby 썸네일 포함
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectHList(){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> list = new MainDao().selectHList(conn);
		close(conn);
		return list;
	}
	
	/**
	 *  2. New Triby 썸네일 포함
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectNlist(){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> nlist = new MainDao().selectNlist(conn);
		close(conn);
		return nlist;
	}
	
	/**
	 *  3_0. 검색어 Triby 갯수 세는 서비스
	 * @param search
	 * @return
	 */
	public int searchListCount(String search) {
		
		Connection conn = getConnection();
		int sc = new MainDao().searchListCount(conn, search);
		close(conn);
		return sc;
	}
	
	/**
	 *  3. 검색 Triby 썸네일 포함
	 * @param search
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchList(String search, PageInfo pi){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> slist = new MainDao().searchList(conn, search, pi);
		close(conn);
		return slist;	
	}
	
	/**
	 *  3_1. 검색 결과 가격순 정렬
	 * @param search
	 * @param pi
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchPriceList(String search, PageInfo pi){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> splist = new MainDao().searchPriceList(conn, search, pi);
		close(conn);
		return splist;	
	}
	
	/**
	 * 3_2. 검색  결과 최신순 정렬
	 * @param search
	 * @param pi
	 * @return
	 */
	public ArrayList<ThumbnailTriby> searchDateList(String search, PageInfo pi){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> sdlist = new MainDao().searchDateList(conn, search, pi);
		close(conn);
		return sdlist;	
	}
	
	
	/**
	 *  4_1 카테고리 검색 (인기)
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectCList(String category) {
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> clistH = new MainDao().selectCList(conn, category);
		close(conn);
		return clistH;
	}
	
	/**
	 *  4_2 카테고리 검색 (조회수)
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectClistv(String category){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> clistV = new MainDao().selectCListv(conn, category);
		close(conn);
		return clistV;
	}
	
	/**
	 *  4_3 카테고리 검색(신규)
	 * @param category
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectClistn(String category){
		
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> clistN = new MainDao().selectClistN(conn, category);
		close(conn);
		return clistN;
	}
	
	/**
	 *  5_1. 디테일 뷰에서 쓸 트리비 정보
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainDetailTriby> detailTriby(int tNo){
		
		Connection conn = getConnection();
		ArrayList<MainDetailTriby> dt = new MainDao().detailTriby(conn, tNo);
		close(conn);
		return dt;
	}
	
	/**
	 * 5_2. 디테일 뷰에서 쓸 호스트 프로필
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainHostDetail> detailHost(int tNo){
		
		Connection conn = getConnection();
		ArrayList<MainHostDetail> dh = new MainDao().detailHost(conn, tNo);
		close(conn);
		return dh;
	}
	
	/**
	 * 5_3. 디테일 뷰에서 쓸 리뷰 상위 1개
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainReviewDetail> detailReview(int tNo){
		
		Connection conn = getConnection();
		ArrayList<MainReviewDetail> dv = new MainDao().detailReview(conn, tNo);
		close(conn);
		return dv;
	}
	
	/**
	 * 5_4. 디테일 뷰에서 쓸 옵션
	 * @param tNo
	 * @return
	 */
	public ArrayList<MainDetailRight> detailRight(int tNo){
		
		Connection conn = getConnection();
		ArrayList<MainDetailRight> dr = new MainDao().detailRight(conn, tNo);
		close(conn);
		return dr;
	}
	
	/**
	 * 5_5. 디테일 뷰에서 other 트리비
	 * @return
	 */
	public ArrayList<ThumbnailTriby> otherTriby(){
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> ot = new MainDao().otherTriby(conn);
		close(conn);
		return ot;
	}
	
	/**
	 * 6. 결제할때 사용할 트리비 썸네일 1개만 필요
	 * @param tNo
	 * @return
	 */
	public ArrayList<ThumbnailTriby> paymentTriby(int tNo) {
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> pt =new MainDao().paymentTriby(conn, tNo);
		close(conn);
		return pt;
	}
	
	/**
	 * 7. 쿠폰 선택 창
	 * @param m
	 * @return
	 */
	public ArrayList<Coupon> couponUse(int m) {
		Connection conn = getConnection();
		ArrayList<Coupon> uC = new MainDao().couponUse(conn, m);
		close(conn);
		return uC;	
	}
	
	/**
	 *  8. 결제 정보 등록 서비스
	 * @param uNo		// 사용자 번호
	 * @param oNo		// 옵션 번호
	 * @param tPayment	// 최종 결제 금액
	 * @param payInfo	// 결제 정보
	 * @param dic		// 할인금액
	 * @return
	 */
	public int payInfo(Payment p){
		
		Connection conn = getConnection();
		
		int result = new MainDao().payInfo(conn, p);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 9. 사용한 쿠폰 사용 완료 처리
	 * @param cNo
	 * @return
	 */
	public int payCoupon(int cNo) {
		Connection conn = getConnection();
		
		int result = new MainDao().payCoupon(conn, cNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 10.option 현재원 증가
	 * @return
	 */
	public int payPerson(int person, int oNo) {
		Connection conn = getConnection();
		
		int result = new MainDao().payCoupon(conn, person, oNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 11. 트리비 좋아요 +1
	 * @param tNo
	 * @return
	 */
	public int tribyLike(int tNo) {
		Connection conn = getConnection();
		
		int result2 = new MainDao().tribyLike(conn, tNo);
		
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result2;
	}
	
	/**
	 * 12. 트리비 좋아요-1
	 * @param tNo
	 * @return
	 */
	public int tribyRemove(int tNo) {
		Connection conn = getConnection();
		
		int result2 = new MainDao().tribyRemove(conn, tNo);
		
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result2;
	}
	
	
}
















