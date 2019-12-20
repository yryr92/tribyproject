package com.triby.calculate.model.vo;

public class Calculate {
	
	private int cal_no;
	private int triby_op_no;
	private int cal_sum;
	private String cal_status;
	
	//////////////////start from pak 10/12
	private String tribyTitle;	//트리비제목
	private int hostNo;			//호스트번호
	private String hostAccName;	//예금주명
	
	public String getTribyTitle() {
		return tribyTitle;
	}

	public void setTribyTitle(String tribyTitle) {
		this.tribyTitle = tribyTitle;
	}

	public int getHostNo() {
		return hostNo;
	}

	public void setHostNo(int hostNo) {
		this.hostNo = hostNo;
	}

	public String getHostAccName() {
		return hostAccName;
	}

	public void setHostAccName(String hostAccName) {
		this.hostAccName = hostAccName;
	}

	public Calculate(int cal_no, int triby_op_no, int cal_sum, String cal_status, String tribyTitle, int hostNo,
			String hostAccName) {
		super();
		this.cal_no = cal_no;
		this.triby_op_no = triby_op_no;
		this.cal_sum = cal_sum;
		this.cal_status = cal_status;
		this.tribyTitle = tribyTitle;
		this.hostNo = hostNo;
		this.hostAccName = hostAccName;
	}
////////////////end from pak 10/12
	
	public Calculate() {}
	
	public Calculate(int cal_no, int triby_op_no, int cal_sum, String cal_status) {
		super();
		this.cal_no = cal_no;
		this.triby_op_no = triby_op_no;
		this.cal_sum = cal_sum;
		this.cal_status = cal_status;
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
	
}
