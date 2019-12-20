package com.triby.tImage.model.vo;

public class Image {
	
	private int iNo;			// 이미지 번호
	private String iName;		// 이미지명
	private String iSrc;		// 이미지 저장경로
	private int iLev;			// 이미지 레벨(1:타이틀, 2~:세부)
	private int tNo;			// 트리비 번호
	
	public Image(){}
	
	public Image(String iName, int tNo) {
		super();
		this.iName = iName;
		this.tNo = tNo;
	}

	public Image(int iNo, String iName, String iSrc, int iLev, int tNo) {
		super();
		this.iNo = iNo;
		this.iName = iName;
		this.iSrc = iSrc;
		this.iLev = iLev;
		this.tNo = tNo;
	}

	public int getiNo() {
		return iNo;
	}

	public void setiNo(int iNo) {
		this.iNo = iNo;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiSrc() {
		return iSrc;
	}

	public void setiSrc(String iSrc) {
		this.iSrc = iSrc;
	}

	public int getiLev() {
		return iLev;
	}

	public void setiLev(int iLev) {
		this.iLev = iLev;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	
}
