package com.triby.qnaHost.model.vo;

import java.sql.Date;

public class QnA {
	
	private int qNo;			// 질의 번호
	private int uNo;			// 회원번호
	private int hNo;			// 호스트 번호
	private String qTitle;		// QnA 제목
	private String qContent;	// QnA 내용
	private String qAnswer;		// QnA 답변
	private String qDate;			// QnA 작성일
	private String aDate;			// QnA 답변 작성일
	private String qStatus;		// QnA 답변 여부
	private String qSecret;		// QnA 비밀글 여부
	private String user_name;	// QnA 작성 회원명
	
	public QnA() {}

	public QnA(int qNo, int uNo, int hNo, String qTitle, String qContent, String qAnswer, String qDate, String aDate,
			String qStatus, String qSecret, String user_name) {
		super();
		this.qNo = qNo;
		this.uNo = uNo;
		this.hNo = hNo;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qAnswer = qAnswer;
		this.qDate = qDate;
		this.aDate = aDate;
		this.qStatus = qStatus;
		this.qSecret = qSecret;
		this.user_name = user_name;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
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

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqAnswer() {
		return qAnswer;
	}

	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}

	public String getqDate() {
		return qDate;
	}

	public void setqDate(String qDate) {
		this.qDate = qDate;
	}

	public String getaDate() {
		return aDate;
	}

	public void setaDate(String aDate) {
		this.aDate = aDate;
	}

	public String getqStatus() {
		return qStatus;
	}

	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}

	public String getqSecret() {
		return qSecret;
	}

	public void setqSecret(String qSecret) {
		this.qSecret = qSecret;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
