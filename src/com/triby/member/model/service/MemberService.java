package com.triby.member.model.service;

import static com.triby.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.member.model.dao.MemberDao;
import com.triby.member.model.vo.Member;
import com.triby.member.model.vo.MyTriby;
import com.triby.qnaHost.model.vo.QnA;
import com.triby.review.model.dao.ReviewDao;
import com.triby.review.model.vo.MyReview;
import com.triby.triby.model.vo.ThumbnailTriby;
import com.triby.common.PageInfo;
import com.triby.coupon.model.vo.Coupon;
import com.triby.likeHost.model.vo.Likehost;

public class MemberService {

	/**
	 * 페이지 갯수 알아오는 서비스
	 * @return 페이지갯수
	 */
	public int adminGetListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new MemberDao().adminGetListCount(conn);
		
		close(conn);
		return listCount;
	}

	/**
	 * 회원 전체정보 조회 서비스
	 * @param pi페이지 갯스
	 * @return 회원리스트
	 */
	public ArrayList<Member> adminSelectMember(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().adminSelectMember(conn, pi);
		
		close(conn);
		return list;
	}
////////////////////////////from PAK 10/01/////////////////////////////////////////	

	/**
	 * 탈퇴한 회원조회 서비스
	 * @param pi 페이지객체
	 * @return 탈퇴한 회원리스트
	 */
	public ArrayList<Member> adminSelectMemberStatus(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().adminSelectMemberStatus(conn, pi);
		
		close(conn);
		return list;
	}


	/**
	 * 회원 번호로 회원 검색하는 서비스
	 * @param input 검색을 요청한 회원번호
	 * @return 검색한 회원리스트
	 */
	public ArrayList<Member> adminSearchUserNoList(String input) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().adminSearchUserNoList(conn, input);
		close(conn);
		return list;
	}

	/**
	 * 회원 이름으로 회원 검색하는 서비스
	 * @param input 검색을 요청한 회원이름
	 * @return 검색한 회원리스트
	 */
	public ArrayList<Member> adminSearchUserNameList(String input) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().adminSearchUserNameList(conn, input);
		close(conn);
		return list;
	}

//////////////////////////from pak 10/05///////////////////////////////////

	/** 회원가입을 위한 메소드
	 * @param mem
	 * @return result
	 */
	public int signupMember(Member mem) {
		Connection conn = getConnection();
		
		int result = new MemberDao().signupMember(conn, mem);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	/** 로그인을 위한 메소드
	 * @param user_email
	 * @param user_pw
	 * @return loginUser
	 */
	public Member loginMember(String user_email, String user_pw) {
		
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, user_email, user_pw);
		
		close(conn);
		
		return loginUser;
	}

	/** 이메일 체크를 위한메소드
	 * @param user_email
	 * @return
	 */
	public int emailCheck(String user_email) {
	
		Connection conn = getConnection();
		
		int result = new MemberDao().emailCheck(conn,user_email);
		
		close(conn);
		
		return result;
	}

	public Member findUser(String userName, String userPhone) {

		Connection conn = getConnection();
		
		Member findMember = new MemberDao().findUser(conn, userName, userPhone);
		
		close(conn);
		
		
		
		return findMember;
	}
////////////////////////////from min 10/05////////////////////////////////////


	/**아이디 찾기 메소드
	 * @param userName
	 * @param UserPhone
	 * @return
	 */
	public String findID( String userName , String UserPhone) {
		
		Connection conn = getConnection();
		
		String findID =  new MemberDao().findID( conn , userName, UserPhone);
		
		close(conn);
		
		return findID;

}
	/** 비밀번호 찾기 메소드
	 * @param userName
	 * @param userEmail
	 * @param userPhone
	 * @return
	 */
	public int findPwd(String userEmail, String userName, String userPhone) {
	
		Connection conn = getConnection();
		
		int result = new MemberDao().findPwd(conn, userEmail , userName, userPhone);

		close(conn);
		
		return result;
	}

	/**
	 * 마이페이지 프로필 불러오는 메소드
	 * @param m
	 * @return
	 */
	public Member selectUserProfile(Member m) {

		Connection conn=getConnection();
		Member user=new MemberDao().userProfile(conn, m);
		int count=new MemberDao().couponCount(conn, m);
		
		user.setuNo(count); 		// 쿠폰개수넣을자리
		close(conn);
		return user;
	}

	/**
	 * 트리비 좋아요 불러오기 메소드
	 * @param m
	 * @param page
	 * @return
	 */
	public ArrayList<ThumbnailTriby> selectLikeTribyList(Member m, int page) {
		Connection conn=getConnection();
		
		ArrayList<ThumbnailTriby> list=new MemberDao().selectLikeTribyList(conn, m, page);
		// 평점계산해서 넣어줄 Dao
		for(int i=0;i<list.size();i++) {
			double point = new MemberDao().selectPoint(conn, list.get(i).getLike());
			list.get(i).setPoint(point);
		}
		close(conn);
		return list;
		
	}

	/**
	 * 트리비좋아요 페이징용 메소드
	 * @param m
	 * @return
	 */
	public int myLikeTribyCount(Member m) {
		Connection conn=getConnection();
		int result=new MemberDao().myLikeTribyCount(conn, m);
		close(conn);
		return result;
		
	}

	/**
	 * 호스트 좋아요 불러오기 메소드
	 * @param m
	 * @param page
	 * @return
	 */
	public ArrayList<Likehost> selectLikeHostList(Member m, int page) {
		Connection conn=getConnection();
		ArrayList<Likehost> list=new MemberDao().selectLikeHostList(conn,m,page);
		
		for(int i=0;i<list.size();i++) {
			int tribyCount=new MemberDao().hostTribyCount(conn,list.get(i).gethNo());
			int reviewCount=new MemberDao().hostReviewCount(conn,list.get(i).gethNo());
			int likeCount=new MemberDao().hostLikeCount(conn,list.get(i).gethNo());
			list.get(i).settCount(tribyCount);
			list.get(i).setRvCount(reviewCount);
			list.get(i).setLikeCount(likeCount);
		}
		close(conn);
		return list;
	}

	public int myLikeHostCount(Member m) {
		Connection conn=getConnection();
		int result=new MemberDao().myLikeHostCount(conn, m);
		close(conn);
		return result;
	}

	public ArrayList<Coupon> selectMyCouponList(Member m) {
		Connection conn=getConnection();
		ArrayList<Coupon> list= new MemberDao().selectMyCouponList(conn,m);
		close(conn);
		return list;
		
	}

	public ArrayList<String> selectCategoryList() {
		Connection conn=getConnection();
		ArrayList<String> list=new MemberDao().selectCategoryList(conn);
		close(conn);
		return list;
		
	}

	public int updateMyCategory(Member m, String category) {
		Connection conn=getConnection();
		int result=new MemberDao().updateMyCategory(conn,m,category);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<MyTriby> selectTribyPreList(Member m, int page) {
		Connection conn=getConnection();
		ArrayList<MyTriby> list=new MemberDao().selectTribyPreList(conn,m,page);
		for(int i=0;i<list.size();i++) {
			String status=new MemberDao().canceledTribySearch(conn,list.get(i).getpNo());
			if(status!=null) {
				list.get(i).setStatus("Y");
			}
		}
		close(conn);
		return list;
		
	}

	public int selectTribyPreListCount(Member m) {
		Connection conn=getConnection();
		int result=new MemberDao().selectTribyPreListCount(conn,m);
		close(conn);
		return result;
	}

	public ArrayList<MyTriby> selectTribyHistoryList(Member m, int page) {
		Connection conn=getConnection();
		ArrayList<MyTriby> list=new MemberDao().selectTribyHistoryList(conn,m,page);
		for(int i=0;i<list.size();i++) {
			String status=new MemberDao().canceledTribySearch(conn,list.get(i).getpNo());
			if(status!=null) {
				list.get(i).setStatus("Y");
			}
		}
		close(conn);
		return list;
	}

	public int selectTribyHistoryListCount(Member m) {
		Connection conn=getConnection();
		int result=new MemberDao().selectTribyHistoryListCount(conn,m);
		close(conn);
		return result;
		
	}

	public MyTriby selectReviewTarget(Member m, int pNo) {
		Connection conn=getConnection();
		MyTriby triby = new MemberDao().selectReviewTarget(conn,m,pNo);
		close(conn);
		return triby;
	}

	public ArrayList<MyReview> selectMyReviewList(Member m, int page) {
		Connection conn=getConnection();
		ArrayList<MyReview> list=new MemberDao().selectMyReviewList(conn,m,page);
		close(conn);
		return list;
	}

	public int selectMyReviewListCount(Member m) {
		Connection conn=getConnection();
		int result=new MemberDao().selectMyReviewListCount(conn,m);
		close(conn);
		return result;
	}

	public int tribyCancel(int pNo) {
		Connection conn=getConnection();
		int result=new MemberDao().tribyCancel(conn,pNo);
		if(result>0) {
			int result2=new MemberDao().decreseTOcount(conn,pNo);
			if(result2>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int removeLikeTriby(Member m, int tNo) {
		Connection conn = getConnection();
		int result=new MemberDao().removeLikeTriby(conn,m,tNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int addLikeTriby(Member m, int tNo) {
		Connection conn = getConnection();
		int result=new MemberDao().addLikeTriby(conn,m,tNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int removeLikeHost(Member m, int hNo) {
		Connection conn = getConnection();
		int result=new MemberDao().removeLikeHost(conn,m,hNo);
		if(result>0) {
			int result2=new MemberDao().decreseHostLikeCount(conn,hNo);
			if(result2>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}
		return result;
	}

	public int addLikeHost(Member m, int hNo) {
		Connection conn = getConnection();
		int result=new MemberDao().addLikeHost(conn,m,hNo);
		if(result>0) {
			int result2=new MemberDao().increseHostLikeCount(conn,hNo);
			if(result2>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}
		return result;
	}

	public int updateProfileImage(Member m, String changeName) {
		Connection conn = getConnection();
		int result=new MemberDao().updateProfileImage(conn,m,changeName);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int updateMyPw(Member m, String pw) {
		Connection conn = getConnection();
		int result=new MemberDao().updateMyPw(conn,m,pw);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int amIlikeHost(Member m, int hNo) {
		Connection conn = getConnection();
		int result=new MemberDao().amIlikeHost(conn,m,hNo);
		close(conn);
		return result;
	}

	public int amIlikeTriby(Member m, int tNo) {
		Connection conn = getConnection();
		int result=new MemberDao().amIlikeTriby(conn,m,tNo);
		close(conn);
		return result;
	}

	public ArrayList<QnA> selectMyQnaList(Member m,int page) {
		Connection conn=getConnection();
		ArrayList<QnA> list=new MemberDao().selectMyQnaList(conn,m,page);
		close(conn);
		return list;
	}

	public int myQnaListCount(Member m) {
		Connection conn = getConnection();
		int result=new MemberDao().myQnaListCount(conn,m);
		close(conn);
		return result;
	}

	public QnA loadMyQcontent(int qNo) {
		Connection conn = getConnection();
		QnA q=new MemberDao().loadMyQcontent(conn,qNo);
		close(conn);
		return q;
	}

	public String qnaHostName(int hNo) {
		Connection conn = getConnection();
		String str=new MemberDao().qnaHostName(conn,hNo);
		close(conn);
		return str;
	}

	/** 비밀번호 재설정을 위한 메소드
	 * @param userId
	 * @param userPwd
	 * @param newPwd
	 * @return
	 */
	public int updatePwd(String userEmail,String newPwd) {
	
		Connection conn =getConnection();
	
		int result= new MemberDao().updatePwd(conn,userEmail, newPwd);
	
	
		if(result>0) {
		commit(conn);
	}else {
		rollback(conn);
	}
		
		
		
		close(conn);
		
	return result;
	}

}