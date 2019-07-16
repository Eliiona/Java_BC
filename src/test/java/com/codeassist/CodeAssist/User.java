package com.codeassist.CodeAssist;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class User extends HttpServlet {

	/**
	 * method which is invoked when root folder (i.e. http://localhost:8080/) of
	 * web application is requested. This method doesn't take any parameters
	 * passed in URL (address).
	 * 
	 * @return string as HTML response to the request using UTF-8 encoding for
	 *         non-Latin characters.
	 */
	@GetMapping("")
	@ResponseBody
	// This method should work without declared name parameter, request and
	// response objects,
	// but it shows, how passed request and returned response can be used inside
	// method
	public void homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * StringBuilder sb = new StringBuilder();
		 * sb.append("<a href='/login'>Login<a><br/>\n"); // Following is also redundant
		 * because status is OK by default:
		 * response.setStatus(HttpServletResponse.SC_OK); return sb.toString();
		 */
		System.out.println();
		try {
		RequestDispatcher view = request.getRequestDispatcher("/home/student/Desktop/workspace/Java_BC/Frontend/templates/login.html");
		view.forward(request, response);
		response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
