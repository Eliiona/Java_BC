package com.codeassist.CodeAssist.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "IssueTable")
public class Issue {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_issue")
	private int id_issue;
	
	@NotNull
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Column(name = "Solved")
	private boolean isSolved = false;
	
	@NotNull
	@Column(name = "Description")
	private String description;
	
	@NotNull
	@Column(name = "Date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "Id_Activity")
	private Activity activity;
	
	@ManyToOne
	@JoinColumn(name = "Id_user")
	private User user;
	
	@OneToMany(mappedBy = "issue")
	private Collection<Reply> replysForIssue;
	
	public Issue(String title, String description, Activity activity) {
		setTitle(title);
		setDescription(description);
		setActivity(activity);
		setDate();
		isSolved = false;
	}
	
	public Issue() {
	}
	
	
	//Set and get methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Activity getExercise() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public int getId_issue() {
		return id_issue;
	}

	public String getDate() {
		
		return date;
	}
	
	public void setDate() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm MM/dd");
		Date dateNow = new Date();
		date = dateFormat.format(dateNow);
	}

	public Activity getActivity() {
		return activity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
	
	
}
