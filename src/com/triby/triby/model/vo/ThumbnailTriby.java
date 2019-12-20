package com.triby.triby.model.vo;

public class ThumbnailTriby {
	private int uNo;
	private int tNo;
	private String tName;
	private int tPrice;
	private int like;
	private String tImg;
	private double point;
	
	public ThumbnailTriby() {
		super();
	}
	
	public ThumbnailTriby(int tNo, String tName, int tPrice, int like, String tImg) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.tPrice = tPrice;
		this.like = like;
		this.tImg = tImg;
	}

	public ThumbnailTriby(int uNo, int tNo, String tName, int tPrice, int like, String tImg, double point) {
		super();
		this.uNo = uNo;
		this.tNo = tNo;
		this.tName = tName;
		this.tPrice = tPrice;
		this.like = like;
		this.tImg = tImg;
		this.point = point;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int gettPrice() {
		return tPrice;
	}
	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String gettImg() {
		return tImg;
	}
	public void settImg(String tImg) {
		this.tImg = tImg;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "ThumbnailTriby [uNo=" + uNo + ", tNo=" + tNo + ", tName=" + tName + ", tPrice=" + tPrice + ", like="
				+ like + ", tImg=" + tImg + ", point=" + point + "]";
	}
	
	
}