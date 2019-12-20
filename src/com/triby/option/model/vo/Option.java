package com.triby.option.model.vo;

public class Option {
	
	private int oNo;			// 트리비 옵션 번호
	private int tId;			// 트리비 번호
	private int person_min;		// 최소인원 < 최대인원
	private int person_max;		// 최소인원 < 최대인원
	private int tAttend;		// 현재참가인원
	private String tDay;			// 트리비 하는 날짜
	private String tTime;		// 트리비 하는 날짜의 시간
	private String status;		// 상태
	
	public Option() {}

	public Option(int oNo, int tId,  int person_min, int person_max, int tAttend, String tDay, String tTime,
			String status) {
		super();
		this.oNo = oNo;
		this.tId = tId;
		this.person_min = person_min;
		this.person_max = person_max;
		this.tAttend = tAttend;
		this.tDay = tDay;
		this.tTime = tTime;
		this.status = status;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getPerson_min() {
		return person_min;
	}

	public void setPerson_min(int person_min) {
		this.person_min = person_min;
	}

	public int getPerson_max() {
		return person_max;
	}

	public void setPerson_max(int person_max) {
		this.person_max = person_max;
	}

	public int gettAttend() {
		return tAttend;
	}

	public void settAttend(int tAttend) {
		this.tAttend = tAttend;
	}

	public String gettDay() {
		return tDay;
	}

	public void settDay(String tDay) {
		this.tDay = tDay;
	}

	public String gettTime() {
		return tTime;
	}

	public void settTime(String tTime) {
		this.tTime = tTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Option [oNo=" + oNo + ", tId=" + tId + ", "  + "person_min=" + person_min
				+ ", person_max=" + person_max + ", tAttend=" + tAttend + ", tDay=" + tDay + ", tTime=" + tTime
				+ ", status=" + status + "]";
	}
	
}
