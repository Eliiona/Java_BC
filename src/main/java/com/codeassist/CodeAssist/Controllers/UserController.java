package com.codeassist.CodeAssist.Controllers;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeassist.CodeAssist.Model.Activity;
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
    
    //Registration controller-----------------------------------------------------------------------------
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "jsp/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "jsp/registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "thymeleaf/myProfile";
    }
    
    
    //Login controller-------------------------------------------------------------------------------------
    /**
     * 
     * @param model
     * @param error
     * @param logout
     * @return
     */
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "jsp/login";
    }
    
    
    //MyProfile Controller---------------------------------------------------------------------------------------
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping({"/", "/myProfile"})
    public String welcome(Model model) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("issueList", issueRepo.findByUser(loggedInUser));
    	model.addAttribute("title", "My Issues");
    	for (Issue i : issueRepo.findByUser(loggedInUser)) {
			System.out.println(i.getTitle());
		}
        return "thymeleaf/myProfile";
    }
    
    @GetMapping("/exercisePage") //goes to webapp folder!!!
    public String task(Model model, HttpServletRequest request) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String activityName = request.getParameter("activity");
    	String title;
    	if (activityName == null||activityName==""){
    		title = "No activity selected";
    	} else {
    		Activity activity = activityRepo.findByName(activityName);
    		if (activity == null){
    			title = "No such activity";
    		}else{
    			title = activityName;
    		}
    	}
    	
    	model.addAttribute("title", title);
    	return "thymeleaf/exercisePage";
    }
    //New Issue Controller----------------------------------------------------------------------------------------
    
    @GetMapping("/newIssue")
    public String newIssueGet(Issue issue, Model model) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	return "thymeleaf/newIssue";
    }
    
    
    @PostMapping("/newIssue")
    public String newIssuePost(Issue issue) {
    	issue.setDate();
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	issue.setUser(loggedInUser);
    	int issueId = issue.getId_issue();
    	issueRepo.save(issue);
    	return "redirect:/issue/" + issueId;
    }
    
    
    //Activity Controller-----------------------------------------------------------------------------------------
    
    
}