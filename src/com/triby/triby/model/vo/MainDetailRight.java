package com.triby.triby.model.vo;

public class MainDetailRight {
	
	private int oNo;		// 옵션번호
	private int pMin;		// 최소인원
	private int pMax;		// 최대인원
	private int tAttend; 	// 현재인원
	private String TDay; 	// 트리비하는날짜
	private String TTime;	// 트리비하는시간
	
	public MainDetailRight() {
		super();
	}
	
	public MainDetailRight(int oNo, int pMin, int pMax, int tAttend, String tDay, String tTime) {
		super();
		this.oNo = oNo;
		this.pMin = pMin;
		this.pMax = pMax;
		this.tAttend = tAttend;
		TDay = tDay;
		TTime = tTime;
	}

	public int getoNo() {
		return oNo;
	}
	public void setoNo(int oNo) {
		this.oNo = oNo;
	}
	public int getpMin() {
		return pMin;
	}
	public void setpMin(int pMin) {
		this.pMin = pMin;
	}
	public int getpMax() {
		return pMax;
	}
	public void setpMax(int pMax) {
		this.pMax = pMax;
	}
	public int gettAttend() {
		return tAttend;
	}
	public void settAttend(int tAttend) {
		this.tAttend = tAttend;
	}
	public String getTDay() {
		return TDay;
	}
	public void setTDay(String tDay) {
		TDay = tDay;
	}
	public String getTTime() {
		return TTime;
	}
	public void setTTime(String tTime) {
		TTime = tTime;
	}
	@Override
	public String toString() {
		return "MainDetailRight [oNo=" + oNo + ", pMin=" + pMin + ", pMax=" + pMax + ", tAttend=" + tAttend + ", TDay="
				+ TDay + ", TTime=" + TTime + "]";
	}
}
