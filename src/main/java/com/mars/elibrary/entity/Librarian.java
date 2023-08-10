package com.mars.elibrary.entity;

import org.springframework.stereotype.Component;

@Component
public class Librarian {
	private int id;
	private String name, number, email, password;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", password="
				+ password + "]";
	}

	
}
