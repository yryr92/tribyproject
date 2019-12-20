package com.triby.triby.model.vo;

public class MainDetailTriby {
	
	private int tNo;			// 트리비 번호
	private String tTitle;		// 트리비 제목
	private int tPrice;			// 트리비 가격
	private int tLike;			// 좋아요 갯수
	private String tImg;		// 이미지 이름
	private String tContent;	// 트리비 소개글
	private String tContent1;	// 포함사항
	private String tContent2;	// 세부일정
	private String tContent3;	// 준비물
	private String address;		// 위치
	private String cCo;			// 카테고리 1개
	
	public MainDetailTriby() {}

	public MainDetailTriby(int tNo, String tTitle, int tPrice, int tLike, String tImg, String tContent,
			String tContent1, String tContent2, String tContent3, String address, String cCo) {
		super();
		this.tNo = tNo;
		this.tTitle = tTitle;
		this.tPrice = tPrice;
		this.tLike = tLike;
		this.tImg = tImg;
		this.tContent = tContent;
		this.tContent1 = tContent1;
		this.tContent2 = tContent2;
		this.tContent3 = tContent3;
		this.address = address;
		this.cCo = cCo;
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

	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}

	public int gettLike() {
		return tLike;
	}

	public void settLike(int tLike) {
		this.tLike = tLike;
	}

	public String gettImg() {
		return tImg;
	}

	public void settImg(String tImg) {
		this.tImg = tImg;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getcCo() {
		return cCo;
	}

	public void setcCo(String cCo) {
		this.cCo = cCo;
	}

	@Override
	public String toString() {
		return "MainDetailTriby [tNo=" + tNo + ", tTitle=" + tTitle + ", tPrice=" + tPrice + ", tLike=" + tLike
				+ ", tImg=" + tImg + ", tContent=" + tContent + ", tContent1=" + tContent1 + ", tContent2=" + tContent2
				+ ", tContent3=" + tContent3 + ", address=" + address + ", cCo=" + cCo + "]";
	}
	
}
