package com.codeassist.CodeAssist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codeassist.CodeAssist.Model.Reply;

import Repo.ReplyRepo;

@Controller
public class DummyController {
	
	@Autowired
	ReplyRepo replyRepo;
	
	@GetMapping(value="/testing")
	public String testing() {
		Reply r1 = new Reply("This might be an answer");
		Reply r2 = new Reply("This might not be an answer");
		Reply r3 = new Reply("This might be a partially right answer");
		
		replyRepo.save(r1);
		replyRepo.save(r2);
		replyRepo.save(r3);

		return "datasaved";
	}
}
