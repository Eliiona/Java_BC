package com.codeassist.CodeAssist.Model;

import java.util.ArrayList;

import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

public class User {
	@NotNull
	@Size(min = 4, max = 4)
	private String id;
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	@NotNull
	@Size(min = 3, max = 20)
	private String surname;
	private ArrayList<String> issues;
	@NotNull
	@Size(min = 6, max = 20)
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
