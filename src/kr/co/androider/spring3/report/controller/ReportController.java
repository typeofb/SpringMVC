package kr.co.androider.spring3.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	
	@RequestMapping("/report")
	public ModelAndView report() {
		
		System.out.println("log - report");
		return new ModelAndView("report");
	}
}
