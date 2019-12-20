package com.triby.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int uNo;				// 회원 번호
	private String email;			// 회원 이메일
	private String pw;				// 회원 비밀번호
	private String name;			// 회원 이름
	private String gender;			// 회원 성별
	private String birth;				// 회원 생일
	private String phone;			// 회원 휴대번호
	private String profile;		// 회원 프로필 이미지
	private String category;		// 회원 관심 카테고리
	private int reportedCount;	// 회원 신고 받은 횟수
	private String registerDate;	// 가입일
	private String modifiedDate;			// 정보수정일
	private String status;			// 탈퇴여부
	private String aralmStatus;		// 알림여부
	private String question;
	
	public Member() {}

	public Member(int uNo, String email, String pw, String name, String gender, String birth, String phone,
			String profile, String category, int reportedCount, String registerDate, String modifiedDate,
			String status, String aralmStatus) {
		super();
		this.uNo = uNo;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.profile = profile;
		this.category = category;
		this.reportedCount = reportedCount;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.aralmStatus = aralmStatus;
	}

	/**회원가입용
	 * @param user_email
	 * @param user_pw
	 * @param user_name
	 * @param user_gender
	 * @param user_phone
	 * @param user_category
	 */
	public Member(String userEmail, String userPw, String userName, String userGender, String userPhone,
			String userCategory) {
		this.email=userEmail;
		this.pw=userPw;
		this.name=userName;
		this.gender=userGender;
		this.phone=userPhone;
		this.category=userCategory;
	}



	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReportedCount() {
		return reportedCount;
	}

	public void setReportedCount(int reported_count) {
		this.reportedCount = reported_count;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAralm_status() {
		return aralmStatus;
	}

	public void setAralm_status(String aralm_status) {
		this.aralmStatus = aralm_status;
	}

	@Override
	public String toString() {
		return "Member [uNo=" + uNo + ", email=" + email + ", pw=" + pw + ", name=" + name + ", gender=" + gender
				+ ", birth=" + birth + ", phone=" + phone + ", profile=" + profile + ", category=" + category
				+ ", reportedCount=" + reportedCount + ", registerDate=" + registerDate + ", modifiedDate="
				+ modifiedDate + ", status=" + status + ", aralmStatus=" + aralmStatus + "]";
	}
	
}