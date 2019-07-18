package com.codeassist.CodeAssist.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.UserRepo;

@Controller
public class SignUpController {
	boolean isRegistered = false;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/signup")
	public String signupGet(User user, Model model) {
		if(isRegistered) {
			String message = "User already exists";
			model.addAttribute("message", message);
		}	
		return "sign-up";
	}
	
	@PostMapping("/signup")
	public String signupPost(User user) {
		if(userRepo.findByUsername(user.getUsername()) != null){
			isRegistered = true;
			return "redirect:/signup";
		}
		else {
			userRepo.save(user);
			return "login";
		}
	}
}
