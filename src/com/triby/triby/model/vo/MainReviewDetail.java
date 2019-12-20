package com.triby.triby.model.vo;

public class MainReviewDetail {
	
	private int hNo;			// 호스트번호
	private String uName;		// 회원이름
	private double RPoint;	// 평점
	private String RContent;	// 리뷰내용
	private String RDate;		// 작성날짜
	
	public MainReviewDetail() {
		super();
	}

	public MainReviewDetail(int hNo, String uName, double rPoint, String rContent, String rDate) {
		super();
		this.hNo = hNo;
		this.uName = uName;
		RPoint = rPoint;
		RContent = rContent;
		RDate = rDate;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public double getRPoint() {
		return RPoint;
	}

	public void setRPoint(double rPoint) {
		RPoint = rPoint;
	}

	public String getRContent() {
		return RContent;
	}

	public void setRContent(String rContent) {
		RContent = rContent;
	}

	public String getRDate() {
		return RDate;
	}

	public void setRDate(String rDate) {
		RDate = rDate;
	}

	@Override
	public String toString() {
		return "MainReviewDetail [hNo=" + hNo + ", uName=" + uName + ", RPoint=" + RPoint + ", RContent=" + RContent
				+ ", RDate=" + RDate + "]";
	}
	
}
