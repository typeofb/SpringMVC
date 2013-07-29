package kr.co.androider.spring3.report.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	@RequestMapping("/reportSelect")
	public ModelAndView reportSelect(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param) {

		System.out.println("log - reportSelect");
		
		// reportForm
		System.out.println(param);
		
		// [{LOC_CD=4009, LOC_NM=남인천}, {LOC_CD=4030, LOC_NM=강화}, {LOC_CD=4043, LOC_NM=시흥}, {LOC_CD=4046, LOC_NM=김포}]
		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("LOC_CD", 4009);
		map1.put("LOC_NM", "남인천");
		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
		map2.put("LOC_CD", 4030);
		map2.put("LOC_NM", "강화");
		ArrayList<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		list.add(map1);
		list.add(map2);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", list);
		mav.setViewName("reportSelect");
		return mav;
	}
}
