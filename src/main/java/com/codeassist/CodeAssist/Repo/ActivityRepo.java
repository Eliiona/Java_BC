package com.codeassist.CodeAssist.Repo;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.Activity;
import com.codeassist.CodeAssist.Model.User;

public interface ActivityRepo extends CrudRepository<Activity, Integer>{
	Activity findByName(String name);

}
