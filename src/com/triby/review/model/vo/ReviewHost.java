package com.triby.review.model.vo;

import java.sql.Date;

public class ReviewHost {
	
	private int rvNo;				// 리뷰 번호
	private	int hNo;				// 호스트 번호
	private String user_name;		// 회원명
	private String rvContent;		// 리뷰 내용
	private String rvImg;			// 첨부 이미지
	private int rvPoint;			// 평점
	private String rvDate;			// 리뷰 작성일
	private String reply;			// 호스트가 단 댓글
	private String Triby;			// 참가 트리비명
	private int uNo;				// 회원번호
	
	public ReviewHost() {
		
	}
	
	public ReviewHost(int rvNo, int hNo, String user_name, String rvContent, String rvImg, int rvPoint, String rvDate,
			String reply, String triby, int uNo) {
		super();
		this.rvNo = rvNo;
		this.hNo = hNo;
		this.user_name = user_name;
		this.rvContent = rvContent;
		this.rvImg = rvImg;
		this.rvPoint = rvPoint;
		this.rvDate = rvDate;
		this.reply = reply;
		this.Triby = triby;
		this.uNo = uNo;
	}

	
	
	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getRvNo() {
		return rvNo;
	}

	public void setRvNo(int rvNo) {
		this.rvNo = rvNo;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getRvDate() {
		return rvDate;
	}

	public void setRvDate(String rvDate) {
		this.rvDate = rvDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getTriby() {
		return Triby;
	}

	public void setTriby(String triby) {
		Triby = triby;
	}	

}
