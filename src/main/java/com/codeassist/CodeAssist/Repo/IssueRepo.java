package com.codeassist.CodeAssist.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.Activity;
import com.codeassist.CodeAssist.Model.Issue;
import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Model.Activity;

public interface IssueRepo extends CrudRepository<Issue, Integer>{
	ArrayList<Issue> findByUser(User user);
	ArrayList<Issue> findByActivity(Activity activity);
}
