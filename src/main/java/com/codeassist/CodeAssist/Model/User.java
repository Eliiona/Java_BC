package com.codeassist.CodeAssist.Model;
import java.util.Collection;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UserTable")
public class User {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_user")
	private int idUser;
	
	@Column(name = "BC_Code")
	@NotNull
	@Size(min = 4, max = 4)
	private String bcCode;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 20)
	private String surname;
	
	@OneToMany(mappedBy = "user")
	private Collection<Issue> issuesForUser;
	
	@OneToMany(mappedBy = "user")
	private Collection<Reply> replysForIssue;
	
	@Column(name = "Password")
	@NotNull
	@Size(min = 6, max = 20)
	private String password;
	
	//constructors
	public User(String name, String surname, String password, String bcCode) {
		setName(name);
		setSurname(surname);
		setPassword(password);
		setBcCode(bcCode);
	}
	
	public User() {		
	}
	
	
	//set and get methods
	public String getBcCode() {
		return bcCode;
	}

	public void setBcCode(String bcCode) {
		this.bcCode = bcCode;
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
	
	public int getId() {
		return idUser;
	}

}
