package com.triby.calculate.model.vo;

public class CalculateHost {

	private int cal_no;
	private int triby_op_no;
	private int cal_sum;
	private String cal_status;
	private String tday;	// 진행날짜
	private String tTitle;	// 트리비명
	private int tAttend;	// 참가인원
	
	public CalculateHost() {
		
	}

	public CalculateHost(int cal_no, int triby_op_no, int cal_sum, String cal_status, String tday, String tTitle,
			int tAttend) {
		super();
		this.cal_no = cal_no;
		this.triby_op_no = triby_op_no;
		this.cal_sum = cal_sum;
		this.cal_status = cal_status;
		this.tday = tday;
		this.tTitle = tTitle;
		this.tAttend = tAttend;
	}

	public int getCal_no() {
		return cal_no;
	}

	public void setCal_no(int cal_no) {
		this.cal_no = cal_no;
	}

	public int getTriby_op_no() {
		return triby_op_no;
	}

	public void setTriby_op_no(int triby_op_no) {
		this.triby_op_no = triby_op_no;
	}

	public int getCal_sum() {
		return cal_sum;
	}

	public void setCal_sum(int cal_sum) {
		this.cal_sum = cal_sum;
	}

	public String getCal_status() {
		return cal_status;
	}

	public void setCal_status(String cal_status) {
		this.cal_status = cal_status;
	}

	public String getTday() {
		return tday;
	}

	public void setTday(String tday) {
		this.tday = tday;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public int gettAttend() {
		return tAttend;
	}

	public void settAttend(int tAttend) {
		this.tAttend = tAttend;
	}

	@Override
	public String toString() {
		return "CalulateHost [cal_no=" + cal_no + ", triby_op_no=" + triby_op_no + ", cal_sum=" + cal_sum
				+ ", cal_status=" + cal_status + ", tday=" + tday + ", tTitle=" + tTitle + ", tAttend=" + tAttend + "]";
	}
	
}
