package com.mars.elibrary.entity;

public class Book {
	private int id, quantity,issued;
	public int getIssued() {
		return issued;
	}
	public void setIssued(int issued) {
		this.issued = issued;
	}
	private String name, column, author, publisher, description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", quantity=" + quantity + ", name=" + name + ", column=" + column + ", author="
				+ author + ", publisher=" + publisher + ", description=" + description + "]";
	}
	
}