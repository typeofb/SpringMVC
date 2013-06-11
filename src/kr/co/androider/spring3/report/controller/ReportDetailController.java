package kr.co.androider.spring3.report.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportDetailController {

	@RequestMapping("/reportDetail")
	public ModelAndView reportDetail(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("log - reportDetail");
		
		return new ModelAndView("reportDetail", "message", request.getParameter("result"));
	}
}
