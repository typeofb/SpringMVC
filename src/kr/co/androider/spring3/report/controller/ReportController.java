package kr.co.androider.spring3.report.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

	@RequestMapping("/reportAjax")
	public void reportAjax(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="txtInput", required=false) String txtInput) throws IOException {

		System.out.println("log - reportAjax");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.write(request.getParameter("txtInput"));
		out.write(txtInput);
	}
	
	@RequestMapping("/reportDetail")
	public ModelAndView reportDetail(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("log - reportDetail");
		
		return new ModelAndView("reportDetail", "message", request.getParameter("result"));
	}
}
