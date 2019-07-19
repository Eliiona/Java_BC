package com.codeassist.CodeAssist.Service;

import com.codeassist.CodeAssist.Model.User;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
