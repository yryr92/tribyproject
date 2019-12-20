package com.triby.report.model.vo;

import java.sql.Date;

public class Report {
	
	private int rNo;			// 신고번호
	private String rDetail;		// 신고유형(상세)
	private Date rDate;			// 신고날짜
	private int rReporter;		// 신고자번호
	private int rTarget;		// 신고대상 번호
	//from pak 10/15
	private String userName;
	private String hostName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Report(int rNo, String rDetail, Date rDate, int rReporter, int rTarget, String userName, String hostName) {
		super();
		this.rNo = rNo;
		this.rDetail = rDetail;
		this.rDate = rDate;
		this.rReporter = rReporter;
		this.rTarget = rTarget;
		this.userName = userName;
		this.hostName = hostName;
	}
///end pak 10/15
	public Report() {}
	
	public Report(int rNo, String rDetail, Date rDate, int rReporter, int rTarget) {
		super();
		this.rNo = rNo;
		this.rDetail = rDetail;
		this.rDate = rDate;
		this.rReporter = rReporter;
		this.rTarget = rTarget;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrDetail() {
		return rDetail;
	}

	public void setrDetail(String rDetail) {
		this.rDetail = rDetail;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getrReporter() {
		return rReporter;
	}

	public void setrReporter(int rReporter) {
		this.rReporter = rReporter;
	}

	public int getrTarget() {
		return rTarget;
	}

	public void setrTarget(int rTarget) {
		this.rTarget = rTarget;
	}
	
}
