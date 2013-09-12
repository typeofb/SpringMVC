package kr.co.androider.spring3.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

@Controller
public class LoginController {
	
	private Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    
	    if (request.getParameter("username").equals("typeofb")) {
	        HttpSession session = request.getSession();
	        session.setAttribute("username", request.getParameter("username"));
	        session.setAttribute("token", new BigInteger(165, new SecureRandom()).toString(36).toUpperCase());
	        logger.debug("##### token = " + session.getAttribute("token") + " #####");
	        return new ModelAndView("login");
	    } else {
	    	// 메시지박스를 출력하고 스크립트를 실행하는 ModelAndView 객체를 리턴
            View view = new AbstractView() {
				@Override
				protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>");
					out.println("alert('Failed to login. The user account does not exist');");
					out.println("location.href='" + req.getContextPath() + "';");
					out.println("</script>");
					out.flush();
				}
            };
            return new ModelAndView(view);
	    }
	}
}