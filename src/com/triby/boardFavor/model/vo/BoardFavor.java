package com.triby.boardFavor.model.vo;

public class BoardFavor {
	
	private int uNo;		// 회원 번호
	private int tNo;		// 트리비 번호
	
	public BoardFavor() {}
	
	public BoardFavor(int uNo, int tNo) {
		super();
		this.uNo = uNo;
		this.tNo = tNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	
}
