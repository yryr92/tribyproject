package com.triby.host.model.vo;

import java.sql.Date;

public class Host {
	
	private int host_no;				// 호스트 No.
	private String host_email;			// 호스트 Email
	private String host_pw;				// 호스트 비밀번호
	private String rn;					// 사업자등록번호
	private String host_sName;			// 호스트 상호명
	private String host_name;			// 이름
	private String host_phone;			// 담당자 연락처
	private String host_accountName;	// 예금주
	private String bank_name;			// 은행명
	private String account;				// 계좌번호
	private int like_count;				// 좋아요 갯수
	private int report_count;			// 누적신고 횟수
	private Date enroll_date;			// 가입일
	private Date modified_date;			// 정보수정날짜
	private String status;				// 탈퇴여부
	private String approval;			// 승인 여부
	private String host_introduce;		// 소개글
	private String host_image;			// 호스트 대표 이미지
	private int thisMtriby;				// 이번 달 신청 트리비 갯수
	private int allTriby;				// 전체 신청 트리비 갯수
	private int reviewCount;			// 호스트 리뷰 갯수
	private double avgPoint;			// 호스트 평균 별점
	private double qnaAnswer;			// qna 응답률
	private int allsales;				// 총매출
	private int thisMsales;				// 이번 달 매출
	
	
	public Host() {}

	public Host(int host_no, String host_email, String host_pw, String rn, String host_sName, String host_name,
			String host_phone, String host_accountName, String bank_name, String account, int like_count,
			int report_count, Date enroll_date, Date modified_date, String status, String approval,
			String host_introduce, String host_image, int thisMtriby, int allTriby, int reviewCount, double avgPoint,
			double qnaAnswer, int allsales, int thisMsales) {
		super();
		this.host_no = host_no;
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.rn = rn;
		this.host_sName = host_sName;
		this.host_name = host_name;
		this.host_phone = host_phone;
		this.host_accountName = host_accountName;
		this.bank_name = bank_name;
		this.account = account;
		this.like_count = like_count;
		this.report_count = report_count;
		this.enroll_date = enroll_date;
		this.modified_date = modified_date;
		this.status = status;
		this.approval = approval;
		this.host_introduce = host_introduce;
		this.host_image = host_image;
		this.thisMtriby = thisMtriby;
		this.allTriby = allTriby;
		this.reviewCount = reviewCount;
		this.avgPoint = avgPoint;
		this.qnaAnswer = qnaAnswer;
		this.allsales = allsales;
		this.thisMsales = thisMsales;
	}

	public Host(int host_no, String host_email, String host_pw, String rn, String host_sName, String host_name,
			String host_phone, String host_accountName, String bank_name, String account, int like_count,
			int report_count, Date enroll_date, Date modified_date, String status, String approval,
			String host_introduce, String host_image) {
		super();
		this.host_no = host_no;
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.rn = rn;
		this.host_sName = host_sName;
		this.host_name = host_name;
		this.host_phone = host_phone;
		this.host_accountName = host_accountName;
		this.bank_name = bank_name;
		this.account = account;
		this.like_count = like_count;
		this.report_count = report_count;
		this.enroll_date = enroll_date;
		this.modified_date = modified_date;
		this.status = status;
		this.approval = approval;
		this.host_introduce = host_introduce;
		this.host_image = host_image;
	}

	public Host(String host_email, String host_pw, String rn, String host_sName, String host_name, String host_phone,
			String host_accountName, String bank_name, String account, String host_introduce) {
		super();
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.rn = rn;
		this.host_sName = host_sName;
		this.host_name = host_name;
		this.host_phone = host_phone;
		this.host_accountName = host_accountName;
		this.bank_name = bank_name;
		this.account = account;
		this.host_introduce = host_introduce;
	}
	
	

	public int getAllsales() {
		return allsales;
	}

	public void setAllsales(int allsales) {
		this.allsales = allsales;
	}

	public int getThisMsales() {
		return thisMsales;
	}

	public void setThisMsales(int thisMsales) {
		this.thisMsales = thisMsales;
	}

	public int getThisMtriby() {
		return thisMtriby;
	}

	public void setThisMtriby(int thisMtriby) {
		this.thisMtriby = thisMtriby;
	}

	public int getAllTriby() {
		return allTriby;
	}

	public void setAllTriby(int allTriby) {
		this.allTriby = allTriby;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getAvgPoint() {
		return avgPoint;
	}

	public void setAvgPoint(double avgPoint) {
		this.avgPoint = avgPoint;
	}

	public double getQnaAnswer() {
		return qnaAnswer;
	}

	public void setQnaAnswer(double qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	public int getHost_no() {
		return host_no;
	}

	public void setHost_no(int host_no) {
		this.host_no = host_no;
	}

	public String getHost_email() {
		return host_email;
	}

	public void setHost_email(String host_email) {
		this.host_email = host_email;
	}

	public String getHost_pw() {
		return host_pw;
	}

	public void setHost_pw(String host_pw) {
		this.host_pw = host_pw;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getHost_sName() {
		return host_sName;
	}

	public void setHost_sName(String host_sName) {
		this.host_sName = host_sName;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getHost_phone() {
		return host_phone;
	}

	public void setHost_phone(String host_phone) {
		this.host_phone = host_phone;
	}

	public String getHost_accountName() {
		return host_accountName;
	}

	public void setHost_accountName(String host_accountName) {
		this.host_accountName = host_accountName;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getReport_count() {
		return report_count;
	}

	public void setReport_count(int report_count) {
		this.report_count = report_count;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getHost_introduce() {
		return host_introduce;
	}

	public void setHost_introduce(String host_introduce) {
		this.host_introduce = host_introduce;
	}

	public String getHost_image() {
		return host_image;
	}

	public void setHost_image(String host_image) {
		this.host_image = host_image;
	}

	@Override
	public String toString() {
		return "Host [host_no=" + host_no + ", host_email=" + host_email + ", host_pw=" + host_pw + ", rn=" + rn
				+ ", host_sName=" + host_sName + ", host_name=" + host_name + ", host_phone=" + host_phone
				+ ", host_accountName=" + host_accountName + ", bank_name=" + bank_name + ", account=" + account
				+ ", like_count=" + like_count + ", report_count=" + report_count + ", enroll_date=" + enroll_date
				+ ", modified_date=" + modified_date + ", status=" + status + ", approval=" + approval
				+ ", host_introduce=" + host_introduce + ", host_image=" + host_image + "]";
	}
	
	
	
	
	
}
