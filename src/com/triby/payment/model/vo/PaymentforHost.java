package com.triby.payment.model.vo;

import java.sql.Date;

public class PaymentforHost {
	
	private int pNo;		// 결제번호
	private int uno;		// 회원 번호
	private int tONo;		// 트리비 옵션 번호
	private String userName; // 회원명
	private Date pDate;		// 결제일
	private String birth;	// 생년월일
	private String gender;	// 성별
	private String phone;	// 연락처
	
	public PaymentforHost() {
		
	}

	public PaymentforHost(int pNo, int uno, int tONo, String userName, Date pDate, String birth, String gender,
			String phone) {
		super();
		this.pNo = pNo;
		this.uno = uno;
		this.tONo = tONo;
		this.userName = userName;
		this.pDate = pDate;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public int getUno() {
		return uno;
	}


	public void setUno(int uno) {
		this.uno = uno;
	}


	public int gettONo() {
		return tONo;
	}


	public void settONo(int tONo) {
		this.tONo = tONo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getpDate() {
		return pDate;
	}


	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}	

}
