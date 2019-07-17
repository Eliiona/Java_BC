package com.codeassist.CodeAssist.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeassist.CodeAssist.Model.User;

@Controller
public class LoginController {
	@GetMapping("/")
	public String loginGet(User user) {
		return "login";
	}

	@PostMapping("/")
	public String loginPost() {
		return "";
	}
}