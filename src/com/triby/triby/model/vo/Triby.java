package com.triby.triby.model.vo;

import java.sql.Date;

public class Triby {
	
	private int tNo;				// 트리비 번호
	private String tTitle;			// 트리비 제목
	private String tContent;		// 트리비 소개글(DB에는 Clob 타입)
	private String tContent1;		// 포함사항
	private String tContent2;		// 새부일정
	private String tContent3;		// 준비물
	private int hNo;				// 호스트 번호
	private String cId1;			// 카테고리 코드1
	private String cId2;			// 카테고리 코드2
	private String cId3;			// 카테고리 코드3
	private String address;			// 위치
	private String appoval_status;	// 승인여부
	private int tLikes;				// 좋아요 갯수
	private Date triby_date;		// 작성일
	private int tViewCount;			// 트리비 조회수
	private int tPrice;				// 트리비 가격
	
	public Triby() {}
	
	public Triby(int tNo, String tTitle, int tPrice, int tLikes) {
		super();
		this.tNo = tNo;
		this.tTitle = tTitle;
		this.tPrice = tPrice;
		this.tLikes = tLikes;
	}

	public Triby(int tNo, String tTitle, String tContent, String tContent1, String tContent2, String tContent3, int hNo,
			String cId1, String cId2, String cId3, String address, String appoval_status, int tLikes, Date triby_date,
			int tViewCount, int tPrice) {
		super();
		this.tNo = tNo;
		this.tTitle = tTitle;
		this.tContent = tContent;
		this.tContent1 = tContent1;
		this.tContent2 = tContent2;
		this.tContent3 = tContent3;
		this.hNo = hNo;
		this.cId1 = cId1;
		this.cId2 = cId2;
		this.cId3 = cId3;
		this.address = address;
		this.appoval_status = appoval_status;
		this.tLikes = tLikes;
		this.triby_date = triby_date;
		this.tViewCount = tViewCount;
		this.tPrice = tPrice;
	}
	public Triby(String tTitle, String tContent, String tContent1, String tContent2, String tContent3, int hNo,
			String cId1, String cId2, String cId3, String address, int tPrice) {
		super();
		this.tTitle = tTitle;
		this.tContent = tContent;
		this.tContent1 = tContent1;
		this.tContent2 = tContent2;
		this.tContent3 = tContent3;
		this.hNo = hNo;
		this.cId1 = cId1;
		this.cId2 = cId2;
		this.cId3 = cId3;
		this.address = address;
		this.tPrice = tPrice;
	}
	
	public Triby(String tTitle, String tContent, String tContent1, String tContent2, String tContent3, int hNo,
			String cId1, String cId2, String cId3, String address) {
		super();
		this.tTitle = tTitle;
		this.tContent = tContent;
		this.tContent1 = tContent1;
		this.tContent2 = tContent2;
		this.tContent3 = tContent3;
		this.hNo = hNo;
		this.cId1 = cId1;
		this.cId2 = cId2;
		this.cId3 = cId3;
		this.address = address;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public String gettContent() {
		return tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	public String gettContent1() {
		return tContent1;
	}

	public void settContent1(String tContent1) {
		this.tContent1 = tContent1;
	}

	public String gettContent2() {
		return tContent2;
	}

	public void settContent2(String tContent2) {
		this.tContent2 = tContent2;
	}

	public String gettContent3() {
		return tContent3;
	}

	public void settContent3(String tContent3) {
		this.tContent3 = tContent3;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public String getcId1() {
		return cId1;
	}

	public void setcId1(String cId1) {
		this.cId1 = cId1;
	}

	public String getcId2() {
		return cId2;
	}

	public void setcId2(String cId2) {
		this.cId2 = cId2;
	}

	public String getcId3() {
		return cId3;
	}

	public void setcId3(String cId3) {
		this.cId3 = cId3;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAppoval_status() {
		return appoval_status;
	}

	public void setAppoval_status(String appoval_status) {
		this.appoval_status = appoval_status;
	}

	public int gettLikes() {
		return tLikes;
	}

	public void settLikes(int tLikes) {
		this.tLikes = tLikes;
	}

	public Date getTriby_date() {
		return triby_date;
	}

	public void setTriby_date(Date triby_date) {
		this.triby_date = triby_date;
	}

	public int gettViewCount() {
		return tViewCount;
	}

	public void settViewCount(int tViewCount) {
		this.tViewCount = tViewCount;
	}

	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
	@Override
	public String toString() {
		return "Triby [tNo=" + tNo + ", tTitle=" + tTitle + ", tContent=" + tContent + ", tContent1=" + tContent1
				+ ", tContent2=" + tContent2 + ", tContent3=" + tContent3 + ", hNo=" + hNo + ", cId1=" + cId1
				+ ", cId2=" + cId2 + ", cId3=" + cId3 + ", address=" + address + ", appoval_status=" + appoval_status
				+ ", tLikes=" + tLikes + ", triby_date=" + triby_date + ", tViewCount=" + tViewCount + ", tPrice="
				+ tPrice + "]";
	}
}
