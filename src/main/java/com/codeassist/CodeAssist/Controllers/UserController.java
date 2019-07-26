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
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeassist.CodeAssist.Model.Activity;
import com.codeassist.CodeAssist.Model.Helper;
import com.codeassist.CodeAssist.Model.Issue;
import com.codeassist.CodeAssist.Model.Reply;
import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.ActivityRepo;
import com.codeassist.CodeAssist.Repo.IssueRepo;
import com.codeassist.CodeAssist.Repo.ReplyRepo;
import com.codeassist.CodeAssist.Repo.UserRepo;
import com.codeassist.CodeAssist.Service.SecurityService;
import com.codeassist.CodeAssist.Service.UserService;
import com.codeassist.CodeAssist.Validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	private ReplyRepo replyRepo;
	
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
     * Passes User object to model and return registration view
     * @param model
     * @return
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "jsp/registration";
    }
    /*
     * Validates all fields and returns error if there is any problem with the input or saves user in database if all fields are correct
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "jsp/registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/myProfile";
    }
    
    
    //Login controller-------------------------------------------------------------------------------------
    /**
     * Returns error if incorrect input in login screen
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
     * Return My Profile view, passes users issues, activity list,  page title, and checks if user is admin
     * @param model
     * @return
     */
    @GetMapping({"/", "/myProfile"})
    public String welcome(Model model) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("isAdmin", loggedInUser.getRole().getId()==2);
    	model.addAttribute("issueList", issueRepo.findByUser(loggedInUser));
    	model.addAttribute("title", "My Issues");
        return "thymeleaf/myProfile";
    }
    
    //Activity controller--------------------------------------------------------------------------------------------------
    /*Returns Activity view , passes activity list, issue list for the current activity and title
     * 
     */
    @GetMapping("/exercisePage")
    public String task(Model model, HttpServletRequest request) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("isAdmin", loggedInUser.getRole().getId()==2);
    	String activityName = request.getParameter("activity");
    	String title;
    	if (activityName == null||activityName==""){
    		title = "No activity selected";
    	} else {
    		Activity activity = activityRepo.findByName(activityName);
    		if (activity == null){
    			title = "No such activity";
    		}else{
    			model.addAttribute("issueList", issueRepo.findByActivity(activity));
    			title = activityName;
    		}
    	}
    	
    	model.addAttribute("title", title);
	
    	return "thymeleaf/exercisePage";
    }
    //New Issue Controller----------------------------------------------------------------------------------------
    /*
     * Return new issue view, passes activity list
     */
    @GetMapping("/newIssue")
    public String newIssueGet(Issue issue, Model model) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	model.addAttribute("activityList2", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("isAdmin", loggedInUser.getRole().getId()==2);
    	return "thymeleaf/newIssue";
    }
    
    /*
     * Creates issue and saves it in database
     */
    @PostMapping("/newIssue")
    public String newIssuePost(Issue issue) {
    	issue.setDate();
    	Activity activity = activityRepo.findById(issue.getActivity().getId()).get();
    	if(activity.getName().isEmpty()) {
    		return "redirect:/newIssue";
    	}
    	else {
    		issue.setActivity(activity);
    		String loggedInUsername = securityService.findLoggedInUsername();
    		User loggedInUser = userRepo.findByUsername(loggedInUsername);
    		issue.setUser(loggedInUser);
    		issueRepo.save(issue);
    	return "redirect:/issue?id=" + issue.getId_issue();
    	}
    }
    
    
    //Current Issue controller-----------------------------------------------------------------------------------------
    /*
     * Returns current issue view, passes activity list, current issue and reply's for current issue
     */
    @GetMapping("/issue")
    public String currentIssueGet(Model model, HttpServletRequest request, Reply reply) {
    	model.addAttribute("activityList", activityRepo.findAll());
    	String loggedInUsername = securityService.findLoggedInUsername();
    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
    	model.addAttribute("isAdmin", loggedInUser.getRole().getId()==2);
    	if (!tryParseInt(request.getParameter("id"))){
    		model.addAttribute("title", "Please select a valid issue");
    		return"redirect:/newIssue";
    	}
    	int issueId = Integer.parseInt(request.getParameter("id"));
    	if(!issueRepo.findById(issueId).isPresent()) { 
    		return"redirect:/newIssue";    		
    	}
    	else {
        	Issue issue = null;
    		issue = issueRepo.findById(issueId).get();
    		model.addAttribute("issue", issue);
    		model.addAttribute("replyList", replyRepo.findByIssue(issue));
    		boolean isOwner = false;
        	if (issue.getUser().getUsername().equals(loggedInUsername)){
        		isOwner=true;
        	}
        	model.addAttribute("isOwner", isOwner);
    	}
    	
    	return "thymeleaf/comments";
    }
    /*
     * Posts a reply for current issue
     */
    @PostMapping("/issue")
    public String currentIssuePost(HttpServletRequest request, Reply reply) {
    	int issueId = Integer.parseInt(request.getParameter("id"));
    	Issue issue = issueRepo.findById(issueId).get();
    	String test = reply.getReplyText().replace(" ", "").replace("\n", "").replace("\r", "");
    	if (!test.isEmpty()){
	    	reply.setDate();
	    	String loggedInUsername = securityService.findLoggedInUsername();
	    	User loggedInUser = userRepo.findByUsername(loggedInUsername);
	    	reply.setUser(loggedInUser);
	    	reply.setIssue(issue);
	    	replyRepo.save(reply);
	    	}
    	return "redirect:/issue?id=" + issueId;
    }
    /*
     * Updates issues status
     */
    @PostMapping("/updateIssue")
    public String updateIssueStatus(HttpServletRequest request) {
    	int issueId = Integer.parseInt(request.getParameter("id"));
    	Issue issue = issueRepo.findById(issueId).get();
    	issue.update();
    	issueRepo.save(issue);
    	return "redirect:/issue?id=" + issueId;
    }

    
    //Admin controller----------------------------------------------------------------------------------------------------
    /*
     * Returns Admin view
     */
    @GetMapping("/admin")
    public String adminGet(Helper helper) {
    	return"thymeleaf/admin";
    }
    /*
     * Generates activity list and saves it in database
     */
    @PostMapping("/admin")
    public String adminPost(Helper helper) {
    	if(helper.getActivityCount() <= 1) {
    		Activity activity = new Activity();
    		activity.setName(helper.getActivityName());
    		activityRepo.save(activity);
    	} else {
    	for(int i = 1; i <= helper.getActivityCount(); i++) {
    		Activity activity = new Activity();
    		if(i < 10) {
    		activity.setName(helper.getActivityName() + "0" + i);
    		}
    		else {
    			activity.setName(helper.getActivityName() + i);
    		}
    		activityRepo.save(activity);
    	}
    	}
    	return"redirect:/admin";
    }

    boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
   }
    
    
    
}