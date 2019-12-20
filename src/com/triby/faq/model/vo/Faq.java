package com.triby.faq.model.vo;

public class Faq {

	private int no;
	private String title;
	private String content;
	
	public Faq() {}

	public Faq(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Faq [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
	
}
