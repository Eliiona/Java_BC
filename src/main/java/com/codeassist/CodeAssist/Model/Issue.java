package com.codeassist.CodeAssist.Model;

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
	private boolean isSolved;
	
	@NotNull
	@Column(name = "Description")
	private String description;
	
	@NotNull
	@Column(name = "Date")
	private Date date;
	
	@NotNull
	@Column(name = "Exercise")
	private int exercise;
	
	@ManyToOne
	@JoinColumn(name = "Id_user")
	private User user;
	
	@OneToMany(mappedBy = "issue")
	private Collection<Reply> replysForIssue;
	
	public Issue(String title, String description, int exercise) {
		setTitle(title);
		setDescription(description);
		setExercise(exercise);
		date = new Date();
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

	public int getExercise() {
		return exercise;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
	}

	public int getId_issue() {
		return id_issue;
	}

	public Date getDate() {
		return date;
	}
	
	
	
	
	
}
