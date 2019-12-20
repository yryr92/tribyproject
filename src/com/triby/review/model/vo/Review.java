package com.triby.review.model.vo;

import java.sql.Date;

public class Review {
	
	private int rvNo;				// 리뷰 번호
	private int pNo;				// 결제 번호
	private	int hNo;				// 호스트 번호
	private int uNo;				// 작성자 번호
	private String rvContent;		// 리뷰 내용
	private String rvImg;			// 첨부 이미지
	private int rvPoint;			// 평점
	private Date rvDate;			// 리뷰 작성일
	private String reply;			// 호스트가 단 댓글

	public Review() {}
	
	public Review(int rvNo, int pNo, int hNo, int uNo, String rvContent, String rvImg, int rvPoint, Date rvDate,
			String reply) {
		super();
		this.rvNo = rvNo;
		this.pNo = pNo;
		this.hNo = hNo;
		this.uNo = uNo;
		this.rvContent = rvContent;
		this.rvImg = rvImg;
		this.rvPoint = rvPoint;
		this.rvDate = rvDate;
		this.reply = reply;
	}

	public int getRvNo() {
		return rvNo;
	}

	public void setRvNo(int rvNo) {
		this.rvNo = rvNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getRvContent() {
		return rvContent;
	}

	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}

	public String getRvImg() {
		return rvImg;
	}

	public void setRvImg(String rvImg) {
		this.rvImg = rvImg;
	}

	public int getRvPoint() {
		return rvPoint;
	}

	public void setRvPoint(int rvPoint) {
		this.rvPoint = rvPoint;
	}

	public Date getRvDate() {
		return rvDate;
	}

	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
