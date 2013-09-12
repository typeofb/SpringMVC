package kr.co.androider.spring3.common.controller;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginSessionCheckInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.debug("##### interceptor preHandle #####");

		StringTokenizer st = new StringTokenizer(request.getRequestURL().toString(), "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals("login.do"))
				return true;
		}

		HttpSession session = request.getSession();
		if (session.getAttribute("token") == null || request.getParameter("token") == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('You are not logged in. Please Log In');");
			out.println("location.href='" + request.getContextPath() + "';");
			out.println("</script>");
			out.flush();
			return false;
		} else {
			if (!session.getAttribute("token").equals(request.getParameter("token"))) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
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