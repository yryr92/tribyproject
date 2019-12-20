package com.triby.member.model.vo;

public class MyTriby {
	private int tNo;			//트리비번호
	private String title;		//트리비제목
	private String address;		//트리비주소
	private String img;			//트리비 대표이미지
	private String tDate;		//트리비 실행일
	private int price;			//트리비 가격
	private int amount;			//수량
	private String pDate;		//결제일
	private String status;		//상태
	private int pNo;			//결제번호
	private int hNo;			//호스트번호
	private String hostName;	//호스트이름
	
	public MyTriby() {
		super();
	}

	public MyTriby(int tNo, String title, String address, String img, String tDate, int price, int amount, String pDate,
			String status, int pNo, int hNo, String hostName) {
		super();
		this.tNo = tNo;
		this.title = title;
		this.address = address;
		this.img = img;
		this.tDate = tDate;
		this.price = price;
		this.amount = amount;
		this.pDate = pDate;
		this.status = status;
		this.pNo = pNo;
		this.hNo = hNo;
		this.hostName = hostName;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
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

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "MyTriby [tNo=" + tNo + ", title=" + title + ", address=" + address + ", img=" + img + ", tDate=" + tDate
				+ ", price=" + price + ", amount=" + amount + ", pDate=" + pDate + ", status=" + status + ", pNo=" + pNo
				+ ", hNo=" + hNo + ", hostName=" + hostName + "]";
	}

	
}