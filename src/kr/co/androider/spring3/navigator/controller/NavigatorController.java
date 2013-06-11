package kr.co.androider.spring3.navigator.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.navigator.vo.NavigatorVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigatorController {
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/navigator")
	public ModelAndView menu(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("menuId"));
		System.out.println(request.getParameter("parentMenuId"));
		
		String targetController = null;
		List<Map> menu = new ArrayList<Map>();
		List<Map> sidebar = new ArrayList<Map>();
		
		// 초기 화면
		if (request.getParameter("menuId") == null && request.getParameter("parentMenuId") == null) {
			
			menu = new NavigatorVo().retrieveMenu();
			
			sidebar = new NavigatorVo().retrieveSidebar();
			
			targetController = "hello.do";
		}
		
		// 헤더 메뉴 클릭
		else if (request.getParameter("parentMenuId") == null || request.getParameter("parentMenuId").equals("")) {
			
			menu = new NavigatorVo().retrieveMenu();
			
			switch (Integer.parseInt(request.getParameter("menuId"))) {
			case 1:
				sidebar = new NavigatorVo().retrieveSidebar();
				targetController = "hello.do";
				break;
			case 2:
				List<Map> temp2 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp2.get(1));
				targetController = "app.do";
				break;
			case 3:
				List<Map> temp3 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp3.get(2));
				targetController = "contact.do";
				break;
			default:
				List<Map> temp4 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp4.get(3));
				targetController = "report.do";
				break;
			}
		}
		
		// 사이드바 클릭
		else {
			
			menu = new NavigatorVo().retrieveMenu();
			
			switch (Integer.parseInt(request.getParameter("menuId"))) {
			case 5:
				List<Map> temp = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp.get(0));
				targetController = "hello.do";
				break;
			case 6:
				List<Map> temp2 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp2.get(1));
				targetController = "app.do";
				break;
			case 7:
				List<Map> temp3 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp3.get(2));
				targetController = "contact.do";
				break;
			default:
				List<Map> temp4 = new NavigatorVo().retrieveSidebar();
				sidebar.add(temp4.get(3));
				targetController = "report.do";
				break;
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", menu);
		mav.addObject("sidebar", sidebar);
		mav.setViewName("forward:/" + targetController);
		return mav;
	}
}
