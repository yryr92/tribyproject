package com.triby.calculate.model.service;

import static com.triby.common.JDBCTemplate.close;
import static com.triby.common.JDBCTemplate.commit;
import static com.triby.common.JDBCTemplate.getConnection;
import static com.triby.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.calculate.model.dao.CalculateDao;
import com.triby.calculate.model.vo.Calculate;
import com.triby.calculate.model.vo.CalculateHost;
import com.triby.host.model.vo.Host;
import com.triby.payment.model.vo.Payment;

public class CalculateService {

/*	*//**
	 * 페이지 갯수 알아오는 서비스
	 * @return
	 *//*
	public int AdminGetListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new CalculateDao().adminGetListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Calculate> selectCalculateList(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}*/
/*
	*//**
	 * 정산테이블에 값 입력하는 서비스
	 * @param tOno
	 * @return
	 *//*
	public int adminInsertCalculate(String[] arr) {
		
		Connection conn = getConnection();
		int result = new CalculateDao().adminInsertCalculate(conn, arr);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}*/

	/**
	 * 정산 상태를 대기중으로 업데이트 하는 서비스
	 * @param list 입금받을 호스트리스트
	 */
	public int adminUpdateOCalculate(ArrayList<Host> list) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().adminUpdateOCalculate(conn, list);
 
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 정산 테이블에 등록하는 서비스
	 * @param list결제정보가 담긴 리스트
	 */
	public void adminInsertNCalculate(ArrayList<Payment> list) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().adminInsertNCalculate(conn, list);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	/**
	 * 정산상태를 완료하는 서비스
	 * @param tOno
	 * @return
	 */
/*	public int updateCalculateDone(int tOno) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().updateCalculateDone(conn, tOno);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}*/
	
	public ArrayList<CalculateHost> selectCalListH(int hNo, int status) {
		
		Connection conn = getConnection();
		
		ArrayList<CalculateHost> list = new CalculateDao().selectCalListH(conn, hNo, status);
		
		close(conn);
		
		return list;
	}

	public int getListCountH(int hNo, int status) {
		
		Connection conn = getConnection();
		
		int result = new CalculateDao().getListCountH(conn, hNo, status);
		
		close(conn);
		
		return result;
	}
//////start from pak 10/12
	/**
	 * 정산테이블 전체 조회서비스
	 * @return
	 */
	public ArrayList<Calculate> adminSelectAllList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Calculate> list = new CalculateDao().adminSelectAllList(conn);
		close(conn);
		return list;
	}
	
	/**
	 * 정산테이블 상태를 N으로 바꾸는 서비스
	 * @param list 결제정보가 담긴 리스트
	 */
	public void adminUpdateNCalculate(ArrayList<Host> list) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().adminUpdateNCalculate(conn,list);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}
	
	/**
	 * 정산테이블 상태를 Y로 바꾸는 서비스
	 * @param toNo
	 * @param sum
	 * @return
	 */
	public int adminUpdateCalculateCom(int toNo, int sum) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().adminUpdateCalculateCom(conn, toNo, sum);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	/////////////end from pak 10/12
	///start from pak 10/13
	/**
	 * 통계 숫자 알아오는 서비스
	 * @return
	 */
	public int adminSelectMemberCount(int menu) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int count = new CalculateDao().adminSelectMemberCount(conn, menu);
		close(conn);
		return count;
	}

	/**
	 * 인기트리비명 조회 서비스
	 * @return
	 */
	public String adminSelectPopular() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String pop = new CalculateDao().adminSelectPopular(conn);
		close(conn);
		return pop;
	}

	/**
	 * 인기 호스트이름 조회 서비스
	 * @return
	 */
	public String adminSelectPopHost() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		String two = new CalculateDao().adminSelectPopHost(conn);
		close(conn);
		return two;
	}
/////////////from pak 10/14
	/**
	 * 정산을 완료하는 서비스
	 * @param cNo 정산번호
	 * @return 정산리스트
	 */
	public int adminCalculateDone(int cNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new CalculateDao().adminCalculateDone(conn, cNo);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	

}
