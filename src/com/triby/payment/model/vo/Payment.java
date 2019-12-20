package com.triby.payment.model.vo;

import java.sql.Date;

public class Payment {
	
	private int pNo;		// 결제번호
	private int uno;		// 회원 번호
	private int tONo;		// 트리비 옵션 번호
	private int pFinal;		// 최종금액
	private String pDate;		// 결제일
	private String pInfo;	// 결제 정보
	private int pDis;		// 할인금액
	private String status;	// 결제상태
	
	public Payment() {}

	public Payment(int pNo, int uno, int tONo, int pFinal, String pDate, String pInfo, int pDis, String status) {
		super();
		this.pNo = pNo;
		this.uno = uno;
		this.tONo = tONo;
		this.pFinal = pFinal;
		this.pDate = pDate;
		this.pInfo = pInfo;
		this.pDis = pDis;
		this.status = status;
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

	public int getpFinal() {
		return pFinal;
	}

	public void setpFinal(int pFinal) {
		this.pFinal = pFinal;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}

	public int getpDis() {
		return pDis;
	}

	public void setpDis(int pDis) {
		this.pDis = pDis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [pNo=" + pNo + ", uno=" + uno + ", tONo=" + tONo + ", pFinal=" + pFinal + ", pDate=" + pDate
				+ ", pInfo=" + pInfo + ", pDis=" + pDis + ", status=" + status + "]";
	}
	
	
}
