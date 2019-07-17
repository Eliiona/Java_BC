package com.codeassist.CodeAssist.Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class Login {
       @GetMapping("/")
       public ModelAndView login() {
    	   ModelAndView mav = new ModelAndView();
   	    mav.setViewName("login");
   	  //  mav.addObject("user", new User());
   	  //  mav.addObject("allProfiles", getProfiles());
   	    return mav;
     }
}