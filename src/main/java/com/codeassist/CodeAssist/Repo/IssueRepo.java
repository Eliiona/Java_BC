package com.codeassist.CodeAssist.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.Issue;
import com.codeassist.CodeAssist.Model.User;

public interface IssueRepo extends CrudRepository<Issue, Integer>{
	ArrayList<Issue> findByUserId(User user);
}
