package kr.co.androider.spring3.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

	@RequestMapping("/report")
	@SuppressWarnings("rawtypes")
	public Model report(Model model, HttpServletRequest request) {

		System.out.println("log - report");

		// Report Index Page 버튼
		if (request.getParameter("menuId") == null || request.getParameter("menuId").equals("")) {
			List<Map> list = new ArrayList<Map>();
			Map<String, String> map = new HashMap<String, String>();
			map.put("firstName", "Hyeon-ho");
			map.put("secondName", "Shin");
			list.add(map);
			model.addAttribute("name", list);
		}
		return model;
	}
}
