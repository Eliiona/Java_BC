package com.codeassist.CodeAssist.Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.UserRepo;

@Controller
public class SignUpController {
	boolean isRegistered = false;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/signup")
	public String signupGet(User user, Model model) {
		String message = "Please fill in this form to create an account.";
		if(isRegistered) {
			message = "User already exists";			
		}
		model.addAttribute("message", message);
		return "sign-up";
	}
	
	@PostMapping("/signup")
	public String signupPost(User user) {
		if(userRepo.findByBcCode(user.getBcCode()) != null){
			isRegistered = true;
			return "redirect:/signup";
		}
		else {
			userRepo.save(user);
			return "login";
		}
	}
}
