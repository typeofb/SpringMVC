package kr.co.androider.spring3.commonMgmt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@RequestMapping("/reportSelect")
	public ModelAndView reportSelect(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param) {

		System.out.println("log - reportSelect");
		
		// reportForm
		System.out.println(param);
		
		// [{AREA_CD=3900, AREA_NM=서울}, {AREA_CD=4500, AREA_NM=충북}, {AREA_CD=5500, AREA_NM=부산}]
		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("AREA_CD", 3900);
		map1.put("AREA_NM", "서울");
		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
		map2.put("AREA_CD", 4500);
		map2.put("AREA_NM", "충북");
		HashMap<Object, Object> map3 = new HashMap<Object, Object>();
		map3.put("AREA_CD", 5500);
		map3.put("AREA_NM", "부산");
		ArrayList<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", list);
		mav.addObject("selected", 5500);	// default area
		mav.setViewName("commonMgmt/reportSelect");
		return mav;
	}
	
	@RequestMapping("/reportSelect2")
	public ModelAndView reportSelect2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<Object, Object> param) {

		System.out.println("log - reportSelect2");
		
		// reportForm
		System.out.println(param.get("selArea"));
		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
		HashMap<Object, Object> map3 = new HashMap<Object, Object>();
		ArrayList<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		if (param.get("selArea").toString().equals("3900")) {
			map1.put("LOC_CD", 3910);
			map1.put("LOC_NM", "은평");
			map1.put("AREA_CD", 3900);
			map2.put("LOC_CD", 3920);
			map2.put("LOC_NM", "강남");
			map2.put("AREA_CD", 3900);
			map3.put("LOC_CD", 3930);
			map3.put("LOC_NM", "종로");
			map3.put("AREA_CD", 3900);
			list.add(map1);
			list.add(map2);
			list.add(map3);
		} else if (param.get("selArea").toString().equals("4500")) {
			map1.put("LOC_CD", 4520);
			map1.put("LOC_NM", "음성");
			map1.put("AREA_CD", 4500);
			map2.put("LOC_CD", 4530);
			map2.put("LOC_NM", "제천");
			map2.put("AREA_CD", 4500);
			map3.put("LOC_CD", 4540);
			map3.put("LOC_NM", "청주");
			map3.put("AREA_CD", 4500);
			list.add(map1);
			list.add(map2);
			list.add(map3);
		} else if (param.get("selArea").toString().equals("5500")) {
			map1.put("LOC_CD", 5550);
			map1.put("LOC_NM", "영도");
			map1.put("AREA_CD", 5500);
			map2.put("LOC_CD", 5560);
			map2.put("LOC_NM", "김해");
			map2.put("AREA_CD", 5500);
			map3.put("LOC_CD", 5570);
			map3.put("LOC_NM", "기장");
			map3.put("AREA_CD", 5500);
			list.add(map1);
			list.add(map2);
			list.add(map3);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", list);
		mav.setViewName("commonMgmt/reportSelect2");
		return mav;
	}
	
	@RequestMapping("/reportAjax")
	public void reportAjax(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="txtInput", required=false) String txtInput) throws IOException {

		System.out.println("log - reportAjax");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
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
	
	// 다른 도메인에 접근할 수 없는 Ajax 보안 제약사항을 우회하기 위한 Proxy 프로그램
	@RequestMapping(value="reportProxy", method=RequestMethod.POST)
	public void reportProxy(HttpServletResponse response,
			@RequestParam(value="value", required=true) String value) throws HttpException, IOException {
		System.out.println(value);
		
		URL url = new URL("http://www.naver.com");
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		int statusCode = httpConnection.getResponseCode();
		
		if (statusCode == HttpStatus.SC_OK) {
			StringBuilder strData = new StringBuilder();
//			InputStream is = url.openStream();
			InputStream is = httpConnection.getInputStream();
			Reader r = new InputStreamReader(is, "UTF-8");
			int data = 0;
			while ((data = r.read()) != -1) {
				strData.append((char) data);
			}
			
			String[] explode = String.valueOf(strData).split("<select name=\"query\">");
			explode = explode[1].split("</select>");
			
			Pattern pattern = Pattern.compile("<option value=\"(.*?)\">(.*?)</option>", Pattern.DOTALL);
			Matcher matcher = pattern.matcher(explode[0]);
			
			StringBuffer returnValue = new StringBuffer();
			returnValue.append("<div>네이버 실시간 검색어 순위</div>");
			returnValue.append("<table>");
			while (matcher.find()) {
				returnValue.append("<tr><td>" + matcher.group(2) + "</td></tr>"); // select option text
			}
			returnValue.append("</table>");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(returnValue);
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
