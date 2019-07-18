package com.codeassist.CodeAssist.Service;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
