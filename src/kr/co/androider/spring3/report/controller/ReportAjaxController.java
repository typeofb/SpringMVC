package kr.co.androider.spring3.report.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportAjaxController {

	@RequestMapping("/reportAjax")
	public void reportAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("log - reportAjax");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(request.getParameter("txtInput"));
	}
}
