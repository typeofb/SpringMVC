package kr.co.androider.spring3.commonMgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HighchartsController {

	@RequestMapping("/highcharts")
	public String highcharts(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("log - highcharts");
		return "commonMgmt/highcharts";
	}
	
	@RequestMapping("/highchartsAjax")
	public void highchartsAjax(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param) throws IOException {
		System.out.println("log - highchartsAjax");
		
		ArrayList<Double> list1 = new ArrayList<Double>();
		list1.add(1386894605000D); // UNIX_TIMESTAMP
		list1.add(918.7700);
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(1386894608000D);
		list2.add(927.4590);
		ArrayList<Double> list3 = new ArrayList<Double>();
		list3.add(1386894611000D);
		list3.add(904.8410);
		ArrayList<Double> list4 = new ArrayList<Double>();
		list4.add(1386894614000D);
		list4.add(1000.1660);
		ArrayList<Double> list5 = new ArrayList<Double>();
		list5.add(1386894617000D);
		list5.add(1024.3590);
		ArrayList<ArrayList<Double>> arrayList = new ArrayList<ArrayList<Double>>();
		arrayList.add(list1);
		arrayList.add(list2);
		arrayList.add(list3);
		arrayList.add(list4);
		arrayList.add(list5);
		
		ArrayList<Double> list6 = new ArrayList<Double>();
		list6.add(1386894608000D);
		list6.add(927.4590);
		ArrayList<Double> list7 = new ArrayList<Double>();
		list7.add(1386894611000D);
		list7.add(967.8410);
		ArrayList<Double> list8 = new ArrayList<Double>();
		list8.add(1386894614000D);
		list8.add(1000.1660);
		ArrayList<ArrayList<Double>> arrayList2 = new ArrayList<ArrayList<Double>>();
		arrayList2.add(list6);
		arrayList2.add(list7);
		arrayList2.add(list8);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("plot", 1386894608000D);
		map.put("plot2", 1386894614000D);
		map.put("data", arrayList);
		map.put("data2", arrayList2);
		JSONObject jsonObj = new JSONObject(map);
		
		response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
		out.print(jsonObj);
	}
}
