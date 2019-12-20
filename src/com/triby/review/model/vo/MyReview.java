package com.triby.review.model.vo;

public class MyReview {
	private int rNo;		// 리뷰번호
	private int pNo;		// 결제번호
	private int hNo;		// 호스트번호
	private int tNo;		// 트리비번호
	private int amount;		// 수량
	private String title;	// 트리비제목
	private String address;	// 주소
	private String img;		// 트리비 썸네일
	private String hostName;// 호스트이름
	private String content;	// 리뷰 내용
	private int point;		// 평점
	private String tDate;	// 트리비 진행일
	private String writeDate;	// 작성일
	private String reply;	// 호스트 답글
	
	public MyReview() {
		super();
	}

	public MyReview(int rNo, int pNo, int hNo, int tNo, int amount, String title, String address, String img,
			String hostName, String content, int point, String tDate, String writeDate, String reply) {
		super();
		this.rNo = rNo;
		this.pNo = pNo;
		this.hNo = hNo;
		this.tNo = tNo;
		this.amount = amount;
		this.title = title;
		this.address = address;
		this.img = img;
		this.hostName = hostName;
		this.content = content;
		this.point = point;
		this.tDate = tDate;
		this.writeDate = writeDate;
		this.reply = reply;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
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

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "MyReview [rNo=" + rNo + ", pNo=" + pNo + ", hNo=" + hNo + ", tNo=" + tNo + ", amount=" + amount
				+ ", title=" + title + ", address=" + address + ", img=" + img + ", hostName=" + hostName + ", content="
				+ content + ", point=" + point + ", tDate=" + tDate + ", writeDate=" + writeDate + ", reply=" + reply
				+ "]";
	}

}
