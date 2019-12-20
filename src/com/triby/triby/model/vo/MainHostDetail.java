package com.triby.triby.model.vo;

public class MainHostDetail {
	
	private int hNo;			// 호스트번호
	private String sName;		// 상호명
	private String hIntroduce; 	// 호스트소개
	private String hImage;		// 호스트이미지

	public MainHostDetail(int hNo, String sName, String hIntroduce, String hImage) {
		super();
		this.hNo = hNo;
		this.sName = sName;
		this.hIntroduce = hIntroduce;
		this.hImage = hImage;
	}

	public MainHostDetail() {
		super();
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String gethIntroduce() {
		return hIntroduce;
	}

	public void sethIntroduce(String hIntroduce) {
		this.hIntroduce = hIntroduce;
	}

	public String gethImage() {
		return hImage;
	}

	public void sethImage(String hImage) {
		this.hImage = hImage;
	}

	@Override
	public String toString() {
		return "MainHostDetail [hNo=" + hNo + ", sName=" + sName + ", hIntroduce=" + hIntroduce + ", hImage=" + hImage
				+ "]";
	}
}
