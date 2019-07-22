package com.codeassist.CodeAssist.Service;

import com.codeassist.CodeAssist.Model.User;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);
	
}
