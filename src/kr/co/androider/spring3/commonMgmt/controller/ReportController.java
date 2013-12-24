package kr.co.androider.spring3.commonMgmt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView reportDetail(@RequestParam HashMap<Object, Object> param) {

		System.out.println("log - reportDetail");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", param.get("txtInput"));
		mav.addObject("result", param.get("result"));
		mav.setViewName("commonMgmt/reportDetail");
		return mav;
	}
	
	@RequestMapping("/reportSelect")
	public ModelAndView reportSelect(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param) {

		System.out.println("log - reportSelect");
		
		// reportForm
		System.out.println(param);
		
		// [{LOC_CD=4009, LOC_NM=남인천}, {LOC_CD=4030, LOC_NM=강화}, {LOC_CD=4043, LOC_NM=시흥}]
		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("LOC_CD", 4009);
		map1.put("LOC_NM", "남인천");
		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
		map2.put("LOC_CD", 4030);
		map2.put("LOC_NM", "강화");
		HashMap<Object, Object> map3 = new HashMap<Object, Object>();
		map3.put("LOC_CD", 4043);
		map3.put("LOC_NM", "시흥");
		ArrayList<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", list);
		mav.addObject("selected", 4030);
		mav.setViewName("commonMgmt/reportSelect");
		return mav;
	}
	
	// 다른 도메인에 접근할 수 없는 Ajax 보안 제약사항을 우회하기 위한 Proxy 프로그램
	@RequestMapping(value="reportProxy", method=RequestMethod.POST)
	public void reportProxy(HttpServletResponse response,
			@RequestParam(value="value", required=true) String value) throws HttpException, IOException {
		System.out.println(value);
		
		String url = "http://www.e-kepco.co.kr/WEATHER/AREA_HQ_MINIWEATHER/tot.php?gubun=" + value;
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		/*
		NameValuePair[] postParams = {
				new NameValuePair("areaCode", value),
				new NameValuePair("groupCode", "G03")
		};
		method.setRequestBody(postParams);
		*/
		int statusCode = client.executeMethod(method);
		
		if (statusCode == HttpStatus.SC_OK) {
			StringBuilder strData = new StringBuilder();
			InputStream is = method.getResponseBodyAsStream();
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				strData.append((char)data);
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(strData.toString());
			out.flush();
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정상적으로 처리되지 않았습니다')");
			out.println("location='login.do'");
			out.println("</script>");
			out.flush();
		}
	}
}
