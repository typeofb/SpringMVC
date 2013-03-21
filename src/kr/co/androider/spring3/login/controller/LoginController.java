package kr.co.androider.spring3.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println("<script>");
	    if (request.getParameter("username").equals("typeofb")) {
	        HttpSession session = request.getSession();
	        session.setAttribute("token", request.getParameter("username"));
	        out.println("location.href='" + request.getContextPath() + "/hello.do" + "';");
	    } else {
            out.println("alert('Failed to login. The user account does not exist');");
            out.println("location.href='" + request.getContextPath() + "';");
	    }
	    out.println("</script>");
	}
}