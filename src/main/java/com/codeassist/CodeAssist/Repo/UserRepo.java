package com.codeassist.CodeAssist.Repo;

import org.springframework.data.repository.CrudRepository;

import com.codeassist.CodeAssist.Model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	User findByUsername(String username);
	User findByUsernameAndPassword(String usernmae, String password);
}
