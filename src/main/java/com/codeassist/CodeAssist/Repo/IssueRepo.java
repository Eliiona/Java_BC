package com.codeassist.CodeAssist.Repo;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.Issue;

public interface IssueRepo extends CrudRepository<Issue, Integer>{

}
