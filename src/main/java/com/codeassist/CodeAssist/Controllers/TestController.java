package com.codeassist.CodeAssist.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/jsp")
    String jspPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "jsp/sample";
    }

    @GetMapping("/thymeleaf")
    String thymeleafPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "thymeleaf/sample";
    }
}
