package com.triby.blackList.model.vo;

import java.sql.Date;

public class BlackList {
	
	private int black_no;
	private int black_target;
	private String black_date;
	
	public BlackList() {}
	
	public BlackList(int black_no, int black_target, String black_date) {
		super();
		this.black_no = black_no;
		this.black_target = black_target;
		this.black_date = black_date;
	}

	public int getBlack_no() {
		return black_no;
	}

	public void setBlack_no(int black_no) {
		this.black_no = black_no;
	}

	public int getBlack_target() {
		return black_target;
	}

	public void setBlack_target(int black_target) {
		this.black_target = black_target;
	}

	public String getBlack_date() {
		return black_date;
	}

	public void setBlack_date(String black_date) {
		this.black_date = black_date;
	}

}
