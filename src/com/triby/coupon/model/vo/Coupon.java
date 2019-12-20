package com.triby.coupon.model.vo;

import java.sql.Date;

public class Coupon {
	
	private int cNo;			// 쿠폰 번호
	private String cName;		// 쿠폰이름
	private int discountRate;		// 할인 금액
	private String couponStart;		// 발급일
	private String couponEnd;		// 만료일
	private String status;		// 사용 여부
	private int uNo;			// 보유한 회원번호
	
	public Coupon() {
		super();
	}
	public Coupon(int cNo, String cName, int discountRate, String couponStart, String couponEnd, String status, int uNo) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.discountRate = discountRate;
		this.couponStart = couponStart;
		this.couponEnd = couponEnd;
		this.status = status;
		this.uNo = uNo;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public String getCouponStart() {
		return couponStart;
	}
	public void setCouponStart(String couponStart) {
		this.couponStart = couponStart;
	}
	public String getCouponEnd() {
		return couponEnd;
	}
	public void setCouponEnd(String couponEnd) {
		this.couponEnd = couponEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	@Override
	public String toString() {
		return "Coupon [cNo=" + cNo + ", cName=" + cName + ", discountRate=" + discountRate + ", couponStart="
				+ couponStart + ", couponEnd=" + couponEnd + ", status=" + status + ", uNo=" + uNo + "]";
	}

	
}
