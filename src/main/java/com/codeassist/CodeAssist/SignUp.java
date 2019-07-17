package com.codeassist.CodeAssist;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SignUp {
    @GetMapping("/signup") 
    public String signup(
        @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
         model.addAttribute("name", name); 
         return "sign-up"; 
         // returns the already proccessed model from src/main/resources/templates/greeting.html 
  }
}
