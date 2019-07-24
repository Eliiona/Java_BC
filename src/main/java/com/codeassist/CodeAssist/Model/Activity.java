package com.codeassist.CodeAssist.Model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "ActivityTable")
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id_Activity")
    private int id;
	
	@Column(name = "Name")
	private String name;
	
	@OneToMany(mappedBy = "activity")
	private Collection<Issue> issueForActivity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}

