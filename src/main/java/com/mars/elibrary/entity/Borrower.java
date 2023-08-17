package com.mars.elibrary.entity;

public class Borrower {
	private String name, mobile, date, book_name; 
	@Override
	public String toString() {
		return "Borrower [name=" + name + ", mobile=" + mobile + ", date=" + date + ", book_name=" + book_name
				+ ", book_id=" + book_id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	private int book_id, id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
