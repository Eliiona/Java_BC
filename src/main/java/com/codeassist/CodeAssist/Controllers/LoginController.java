package com.codeassist.CodeAssist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.UserRepo;

@Controller
public class LoginController {
	private boolean incorrectCredentials = false;
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public String loginGet(User user, Model model) {
		if(incorrectCredentials) {
			String message = "Username or password incorrect";
			model.addAttribute(message, message);
		}
		return "login";
	}

	@PostMapping("/")
	public String loginPost(User user) {
		if(userRepo.findByBcCodeAndPassword(user.getBcCode(), user.getPassword()) != null) {
			return "redirect:/MyProfile";
		} else {
			incorrectCredentials = true;
			return "redirect:/";
		}
	}
}