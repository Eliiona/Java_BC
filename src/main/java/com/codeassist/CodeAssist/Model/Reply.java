package com.codeassist.CodeAssist.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String replyText;
	
	@Column(name = "status")
	private boolean isSolution;
	
	@Column(name = "date")
	private Date creationDate;
	
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
		this.creationDate = new Date();
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	//public User getUser() {
	//	return user;
	//}

	//public void setUser(User user) {
	//	this.user = user;
	//}
}
