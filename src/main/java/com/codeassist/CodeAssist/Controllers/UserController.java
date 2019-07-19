package com.codeassist.CodeAssist.Controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeassist.CodeAssist.Model.Issue;
import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.ActivityRepo;
import com.codeassist.CodeAssist.Repo.IssueRepo;
import com.codeassist.CodeAssist.Repo.UserRepo;
import com.codeassist.CodeAssist.Service.SecurityService;
import com.codeassist.CodeAssist.Service.UserService;
import com.codeassist.CodeAssist.Validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private IssueRepo issueRepo;
	
	@Autowired
	private ActivityRepo activityRepo;
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/myProfile";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/myProfile"})
    public String welcome(Model model) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("issueList", issueRepo.findByUser(loggedInUser));
    	for (Issue i : issueRepo.findByUser(loggedInUser)) {
			System.out.println(i.getTitle());
		}
        return "myProfile";
    }
}