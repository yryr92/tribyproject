package com.triby.notice.model.service;

import static com.triby.common.JDBCTemplate.*;
import static com.triby.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.notice.model.dao.NoticeDao;
import com.triby.notice.model.vo.Notice;
import com.triby.common.PageInfo;
import com.triby.faq.model.vo.Faq;

public class NoticeService {


	/**
	 * 공지사항 리스트 보여주는 서비스
	 * @return 공지사항 리스트
	 */
	public ArrayList<Notice> selectNoticeListAdmin(PageInfo pi) {
		
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeListAdmin(conn, pi);
		
		close(conn);
		
		return list;
	}

	/**
	 * 공지사항 리스트 갯수 알아오는 서비스
	 * @return 리스트 갯수
	 */
	public int adminGetListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new NoticeDao().adminGetListCount(conn);
		
		close(conn);	
		return listCount;
		
	}

	/**
	 * 공지사항 상세보기 서비스
	 * @param nNo
	 * @return
	 */
	public Notice selectNoticeAdmin(int nNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Notice notice = new NoticeDao().selectNoticeAdmin(conn, nNo);
		
		close(conn);
		return notice;
	}

	/**
	 * 공지사항 업데이트 서비스
	 * @param notice
	 * @return
	 */
	public Notice updateNotice(Notice notice) {
		
		Connection conn = getConnection();
		int result = new NoticeDao().updateNotice(conn, notice);
	
		Notice newNotice = null;
		if(result>0) {
			commit(conn);
			newNotice = new NoticeDao().selectNoticeAdmin(conn, notice.getnNo());	
		}else {
			rollback(conn);
		}
		close(conn);
	
		return newNotice;
	}

	/**
	 * 공지사항 작성 서비스
	 * @param notice
	 * @return
	 */
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, notice);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 공지사항 삭제 서비스
	 * @param nNo
	 * @return
	 */
	public int deleteNotice(int nNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn, nNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 분류된 공지사항 리스트 조회 서비스
	 * @param pi
	 * @param selected 분류된 리스트
	 * @return
	 */
	public ArrayList<Notice> selectNoticeListSelectedAdmin(PageInfo pi, String selected) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeListSelectedAdmin(conn, pi, selected);
		
		close(conn);
		return list;

	}

	/**
	 * 비공개 공지사항 조회서비스
	 * @param pi
	 * @param selected 비공개리스트
	 * @return
	 */
	public ArrayList<Notice> selectNoticeListSecretAdmin(PageInfo pi, String secret) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeListSecretAdmin(conn, pi, secret);
		
		close(conn);
		return list;
	}
	///////////////////////////from PAK 10/01///////////////////////////////////

	/**
	 * 공지사항 검색한 리스트
	 * @param search
	 * @return
	 */
	public ArrayList<Notice> adminSearchNoticeList(PageInfo pi, String title) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().adminSearchNoticeList(conn,pi,title);
		close(conn);
		return list;
	}

	/**
	 * 정렬한 페이지 갯수 알아오는 서비스
	 * @param selected
	 * @return
	 */
	public int adminGetSelectedListCount(String selected) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int selectedListCount = 0;

		switch(selected) {
		case "공지" : selectedListCount = new  NoticeDao().adminGetNoticeListCount(conn); break;
		case "이벤트" : selectedListCount = new NoticeDao().adminGetEventListCount(conn); break;
		case "호스트" : selectedListCount = new NoticeDao().adminGetHostListCount(conn); break;
		case "N" : selectedListCount = new NoticeDao().adminGetSecretListCount(conn); break;
		}
		
		close(conn);
		return selectedListCount;

	}

	/**
	 * 검색한 공지사항 리스트 갯수 알아오는 서비스
	 * @return
	 */
	public int adminGetSearchListCount(String title) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int searchListCount = new NoticeDao().adminGetSearchListCount(conn,title);
		close(conn);
		System.err.println("service: "+searchListCount);
		return searchListCount;
	}
	///////////////////////////from pak 10/05//////////////////////////////
	public ArrayList<Notice> selectListh(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectListh(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int getListhCount() {
		
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().getListhCount(conn);
		
		close(conn);
		
		return listCount;
	}
///////////////////////from rin 10/05//////////////////////////////

	public ArrayList<Notice> loadMainNotice(int page) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().loadMainNotice(conn, page);
		
		close(conn);
		
		return list;
		
	}

	public ArrayList<Notice> loadCategoryNotice(String category, int page) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().loadCategoryNotice(conn,category,page);
		
		close(conn);
		
		return list;
	}

	public int mainNoticeCount(String category) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().mainNoticeCount(conn,category);
		
		close(conn);
		
		return result;
	}

	public int mainNoticeCount() {
		Connection conn = getConnection();
		
		int result = new NoticeDao().mainNoticeCount(conn);
		
		close(conn);
		
		return result;
	}

	public String loadMainNoticeContent(int nNo) {
		Connection conn = getConnection();
		
		String str = new NoticeDao().loadMainNoticeContent(conn,nNo);
		
		close(conn);
		
		return str;
	}

	public ArrayList<Faq> loadMainFaqList(int page) {
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new NoticeDao().loadMainFaqList(conn,page);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Faq> loadMainFaqList(String key, int page) {
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new NoticeDao().loadMainFaqList(conn,key,page);
		
		close(conn);
		
		return list;
	}

	public int loadMainFaqCount() {
		Connection conn = getConnection();
		
		int result = new NoticeDao().loadMainFaqCount(conn);
		
		close(conn);
		
		return result;
	}

	public int loadMainFaqCount(String key) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().loadMainFaqCount(conn,key);
		
		close(conn);
		
		return result;
	}
		public ArrayList<Notice> selectMnlist() {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectMnlist(conn);
		
		close(conn);
		
		return list;
		
	}
	
}
