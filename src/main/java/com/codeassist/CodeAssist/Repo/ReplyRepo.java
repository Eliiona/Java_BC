package com.codeassist.CodeAssist.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.Issue;
import com.codeassist.CodeAssist.Model.Reply;

public interface ReplyRepo extends CrudRepository<Reply, Integer> {
	ArrayList<Reply> findByIssue(Issue issue);

}
