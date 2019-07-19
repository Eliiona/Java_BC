package com.codeassist.CodeAssist.Model;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "UserTable")
public class User {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_user")
	private int idUser;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Surname")
	private String surname;
	
	@OneToMany(mappedBy = "user")
	private Collection<Issue> issuesForUser;
	
	@OneToMany(mappedBy = "user")
	private Collection<Reply> replysForIssue;
	
    @OneToOne
    private Role role;
	
	@Column(name = "Password")
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	//constructors
	public User(String name, String surname, String password, String bcCode) {
		setName(name);
		setSurname(surname);
		setPassword(password);
		setUsername(bcCode);
	}
	
	public User() {		
	}
	
	
	//set and get methods
	public String getUsername() {
		return username;
	}

	public void setUsername(String bcCode) {
		this.username = bcCode;
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
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
