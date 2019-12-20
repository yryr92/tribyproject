package com.triby.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int nNo;			// 공지 번호
	private String nCategory;	// 공지분류(공지사항 / 이벤트  / 호스트)
	private String nTitle;		// 공지제목
	private String nContent;	// 공지내용
	private Date nDate;			// 작성일
	private String nStatus;		// 게시여부
	private String sDate;

	public Notice() {}

	public Notice(int nNo, String nCategory, String nTitle, String nContent, Date nDate, String nStatus) {
		super();
		this.nNo = nNo;
		this.nCategory = nCategory;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nStatus = nStatus;
	}

	public Notice(int nNo, String nCategory, String nTitle, String nContent, String nStatus, String sDate) {
		super();
		this.nNo = nNo;
		this.nCategory = nCategory;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nStatus = nStatus;
		this.sDate = sDate;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnCategory() {
		return nCategory;
	}

	public void setnCategory(String nCategory) {
		this.nCategory = nCategory;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getnStatus() {
		return nStatus;
	}

	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nCategory=" + nCategory + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", nDate=" + nDate + ", nStatus=" + nStatus + ", sDate=" + sDate + "]";
	}
	
}
