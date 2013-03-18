package kr.co.androider.spring3.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	    
	    HttpSession session = request.getSession();
	    String sessionId = session.getId();
	    
	    session.setAttribute("token", request.getParameter("username"));
	    
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		return new ModelAndView("main", "message", message);
	}
}