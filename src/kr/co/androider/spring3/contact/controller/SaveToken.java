package kr.co.androider.spring3.contact.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveToken {
	
	public void setToken(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("token", new BigInteger(165, new SecureRandom()).toString(36).toUpperCase());
	}
	
	public boolean isValid(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
        if (session.getAttribute("token") == null || request.getParameter("token") == null) {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
            out.println("<script>");
            out.println("alert('You are not logged in. Please Log In');");
            out.println("location.href='" + request.getContextPath() + "';");
            out.println("</script>");
            out.flush();
            return false;
        } else {
        	if (!session.getAttribute("token").equals(request.getParameter("token"))) {
        		response.setContentType("text/html; charset=utf-8");
                PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
                out.println("<script>");
                out.println("alert('This task is already running or is an unusual request');");
                out.println("location.href='" + request.getContextPath() + "';");
                out.println("</script>");
                out.flush();
                return false;
        	}
        }
		return true;
	}
}