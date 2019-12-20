package com.triby.likeHost.model.vo;

public class Likehost {
	
	private int uNo;	// 회원 번호
	private int hNo;	// 호스트 번호
	private String hName; // 호스트 이름
	private String hImg;	//호스트 프사
	private int tCount;	//트리비 개수
	private int rvCount;	// 리뷰개수
	private int likeCount;	// 좋아요개수
	public Likehost() {
		super();
	}
	public Likehost(int uNo, int hNo, String hName, String hImg, int tCount, int rvCount, int likeCount) {
		super();
		this.uNo = uNo;
		this.hNo = hNo;
		this.hName = hName;
		this.hImg = hImg;
		this.tCount = tCount;
		this.rvCount = rvCount;
		this.likeCount = likeCount;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethImg() {
		return hImg;
	}
	public void sethImg(String hImg) {
		this.hImg = hImg;
	}
	public int gettCount() {
		return tCount;
	}
	public void settCount(int tCount) {
		this.tCount = tCount;
	}
	public int getRvCount() {
		return rvCount;
	}
	public void setRvCount(int rvCount) {
		this.rvCount = rvCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	@Override
	public String toString() {
		return "Likehost [uNo=" + uNo + ", hNo=" + hNo + ", hName=" + hName + ", hImg=" + hImg + ", tCount=" + tCount
				+ ", rvCount=" + rvCount + ", likeCount=" + likeCount + "]";
	}
	
	
		
}
