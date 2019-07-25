package com.codeassist.CodeAssist.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReplyTable")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_reply")
	private int replyId;
	
	@Column(name = "text_reply")
	@Lob
	private String replyText;
	
	@Column(name = "status")
	private boolean isSolution = false;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "Id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "Id_issue")
	private Issue issue;
	
	public Reply(){
		super();
	}
	
	public Reply(String text ) {
		this.replyText = text;
		this.isSolution = false;
	}

	public int getId_reply() {
		return replyId;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public boolean isSolution() {
		return isSolution;
	}

	public void setSolution(boolean isSolution) {
		this.isSolution = isSolution;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm MM/dd");
		Date dateNow = new Date();
		date = dateFormat.format(dateNow);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	
}
