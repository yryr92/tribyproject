package com.triby.host.model.service;

import static com.triby.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.calculate.model.service.CalculateService;
import com.triby.common.PageInfo;
import com.triby.host.model.dao.HostDao;
import com.triby.host.model.vo.Host;
import com.triby.member.model.dao.MemberDao;
import com.triby.review.model.vo.MyReview;
import com.triby.triby.model.vo.ThumbnailTriby;

public class HostService {

	/**
	 * 리스트 갯수 조회 서비스
	 * @return 호스트리스트 갯수
	 */
	public int adminGetListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new HostDao().adminGetListCount(conn);
		
		close(conn);
		return listCount;
	}

	/**
	 * 호스트 리스트 조회 서비스
	 * @param pi 페이지 
	 * @return 호스트리스트
	 */
	public ArrayList<Host> selectHostAdmin(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().selectHostAdmin(conn, pi);
		
		close(conn);
		return list;
	}
/////////////////from PAK 10/01//////////////////////////////////

	/**
	 * 호스트 승인하는 서비스
	 * @param hostNo
	 * @return
	 */
	public int adminUpdateHostApproval(int hostNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new HostDao().adminUpdateHostApproval(conn, hostNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 탈퇴한 호스트 리스트를 조회하는 서비스
	 * @param pi
	 * @return
	 */
	public ArrayList<Host> selectHostAdminStatus(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().selectHostAdminStatus(conn, pi);
		
		close(conn);
		return list;
	}

	/**
	 * 호스트 승인을 취소하는 서비스
	 * @param hostNo
	 * @return
	 */
	public int adminUpdateHostDisapproval(int hostNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new HostDao().adminUpdateHostDisapproval(conn, hostNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 호스트번호로 검색한 호스트리스트 불러오는 서비스
	 * @param input 검색할 호스트번호
	 * @return
	 */
	public ArrayList<Host> adminSearchHostNoList(String input) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().adminSearchHostNoList(conn, input);
		close(conn);
		return list;
	}

	/**
	 * 호스트이름으로 검색한 호스트리스트 불러오는 서비스
	 * @param input
	 * @return
	 */
	public ArrayList<Host> adminSearchHostNameList(String input) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().adminSearchHostNameList(conn, input);
		close(conn);
		return list;
	}
	
	//////////////////////from pak 10/05///////////////////////////////////

	/** 호스트 회원가입용 메소드
	 * @param ho
	 * @return result
	 */
	public int signHost(Host ho) {
		Connection conn = getConnection();
		
		
		int result = new HostDao().signHost(conn, ho);
		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/** 호스트 이메일 체크를 위한 메소드
	 * @param host_email
	 * @return
	 */
	public int emailCheck(String hostEmail) {
		Connection conn = getConnection();
		
		
		int result =  new HostDao().emailCheck(conn, hostEmail);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Host loginHost(String email, String pw) {
		
		Connection conn = getConnection();
		
		Host loginHost = new HostDao().loginHost(conn, email, pw);
		
		close(conn);
		
		return loginHost;
	}

	public Host updateHost(Host h) {
		
		Connection conn = getConnection();
		
		int result = new HostDao().updateHost(conn, h);
		
		Host updateH = null;
		
		if(result > 0) {
			commit(conn);
			updateH = new HostDao().selectHost(conn, h.getHost_email());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateH;
	}
	
	

	///////////////////////////from rin 10/05////////////////////////////////

	/** 아이디 찾기 메소드
	 * @param hostName
	 * @param hostPhone
	 * @return
	 */
	public String findID(String hostName, String hostPhone) {
		
		Connection conn = getConnection();
		
		String findID = new HostDao().findID( conn, hostName, hostPhone);
		
		close(conn);
		
		return findID;
	}

	/** 비밀번호 찾기 메소드
	 * @param hostName
	 * @param hostEmail
	 * @param hostPhone
	 * @return
	 */
	public int findPwd(String hostName, String hostEmail, String hostPhone) {
		
		Connection conn = getConnection();
		
		int result = new HostDao().findPwd(conn, hostName, hostEmail, hostPhone);
		
		close(conn);
		
		
		return result;
		
		
	}
//////////////////////////////from rin 10/07///////////////////////////////////////
	/**
	 * 호스트비밀번호체크서비스
	 * @param pw
	 * @return
	 */
	public int checkHostPwAdmin(Host loginHost, String hostPw) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		//String hostEmail = loginHost.getHost_email();
		//Host checkHost = new HostDao().selectHost(conn, hostEmail);//HostDao에 selectHost()수정시 함께 수정해야함
		String userPw = new HostDao().selectChangeHostPw(conn, loginHost.getHost_no());
	
		int check = 0;
		
		if(hostPw.equals(userPw)) {
			check= 1;
		}
		close(conn);
		return check;
	}

	/**
	 * 호스트 비밀번호 수정하는 서비스
	 * @param newPw
	 * @return
	 */
	public int updateHostPwAdmin(int hostNo, String newPw) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new HostDao().updateHostPwAdmin(conn, hostNo, newPw);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	////////////////////////////from pak 10/07/////////////////////////////////////////////////

	/**
	 * 정산용 호스트 리스트 조회 서비스
	 * @param arr
	 * @return
	 */
	public ArrayList<Host> adminSelectCalHost(String[] arr) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().adminSelectCalHost(conn, arr);
/*		if(!list.isEmpty()) {
			new CalculateService().adminInsertCalculate(list);
		}*/
		close(conn);
		return list;
	}

	/**
	 * 정산을 기다리는 호스트리스트 조회서비스
	 * @return
	 */
	public ArrayList<Host> adminSelectWaitHostList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Host> list = new HostDao().adminSelectWaitHostList(conn);
		close(conn);
		return list;
	}

	public Host mainHostDetail(int hNo) {
		Connection conn = getConnection();
		Host h = new HostDao().mainHostDetail(conn,hNo);
		close(conn);
		return h;
		
		
	}

	public ArrayList<String> mainHostCount(int hNo) {
		Connection conn = getConnection();
		ArrayList<String> list = new ArrayList<>();
		String n1=new HostDao().mainHostTribyCount(conn,hNo);
		String n2=new HostDao().mainHostReviewCount(conn,hNo);
		String n3=new HostDao().mainHostLikeCount(conn,hNo);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		close(conn);
		return list;
	}

	public ArrayList<ThumbnailTriby> loadHostTribyList(int hNo, int page) {
		Connection conn = getConnection();
		ArrayList<ThumbnailTriby> list = new HostDao().loadHostTribyList(conn,hNo,page);
		double point = new MemberDao().selectPoint(conn, hNo);
		for(int i=0;i<list.size();i++) {
			list.get(i).setPoint(point);
		}
		close(conn);
		return list;
	}

	public ArrayList<MyReview> loadHostReviewList(int hNo, int page) {
		Connection conn = getConnection();
		ArrayList<MyReview> list = new HostDao().loadHostReviewList(conn,hNo,page);
		close(conn);
		return list;
	}

	public int loadHostTribyListCount(int hNo) {
		Connection conn = getConnection();
		int result = new HostDao().loadHostTribyListCount(conn,hNo);
		close(conn);
		return result;
	}

	public int loadHostReviewListCount(int hNo) {
		Connection conn = getConnection();
		int result = new HostDao().loadHostReviewListCount(conn,hNo);
		close(conn);
		return result;
	}
	
	public ArrayList<Integer> HostInformation(Host loginHost) {
		
		ArrayList<Integer> plus = new ArrayList<>();
		
		Connection conn = getConnection();
		
		int thisMTriby = new HostDao().thisMTriby(conn, loginHost);
		int allTriby = new HostDao().allTriby(conn, loginHost);
		int reviewCountH = new HostDao().ReviewCountH(conn, loginHost);
		int thisMsales = new HostDao().thisMsales(conn, loginHost);
		int allSales = new HostDao().allSales(conn, loginHost);
		
		close(conn);
		
		plus.add(thisMTriby);
		plus.add(allTriby);
		plus.add(reviewCountH);
		plus.add(thisMsales);
		plus.add(allSales);
		
		return plus;
	}

	public double ReviewAverage(Host loginHost) {
		
		Connection conn = getConnection();
		
		int reviewCountH = new HostDao().ReviewCountH(conn, loginHost);
		int reviewSumH = new HostDao().ReviewSumH(conn, loginHost);
		
		close(conn);
		
		double avg = (double) reviewSumH / reviewCountH;
		
		return avg;
	}

	public double qnaAnswerPercent(Host loginHost) {
		
		Connection conn = getConnection();
		
		int qnaCountH = new HostDao().qnaCountH(conn, loginHost);
		int qnaCountY = new HostDao().qnaCountY(conn, loginHost);
		
		double per =  (((double)qnaCountY / qnaCountH) * 100);
		
		return per;
	}
	
	public int updatePwd(String hostEmail, String newPwd) {
		
		Connection conn = getConnection();
		
		int result = new HostDao().updatePwd(conn,hostEmail,newPwd);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		close(conn);
		
		return result;
	}
	
}
