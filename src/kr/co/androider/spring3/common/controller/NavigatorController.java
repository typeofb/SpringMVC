package kr.co.androider.spring3.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.common.vo.NavigatorVO;

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
			menu = new NavigatorVO().retrieveMenu();
			
			List<Map> temp = new NavigatorVO().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if ("0001".equals(temp.get(i).get("parentMenuId"))) {
					sidebar.add(temp.get(i));
					if ("1001".equals(temp.get(i).get("menuId"))) {
						targetController = temp.get(i).get("controllerName").toString();
					}
				}
			}
		}
		
		// 헤더 메뉴 클릭
		else if (request.getParameter("parentMenuId") == null || request.getParameter("parentMenuId").equals("")) {
			menu = new NavigatorVO().retrieveMenu();
			
			List<Map> temp = new NavigatorVO().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if (request.getParameter("menuId").equals(temp.get(i).get("parentMenuId"))) {
					sidebar.add(temp.get(i));
				}
			}
			
			for (int i = 0; i < menu.size(); i++) {
				if (request.getParameter("menuId").equals(menu.get(i).get("menuId"))) {
					targetController = menu.get(i).get("controllerName").toString();
				}
			}
		}
		
		// 사이드바 클릭
		else {
			menu = new NavigatorVO().retrieveMenu();
			
			List<Map> temp = new NavigatorVO().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if (request.getParameter("parentMenuId").equals(temp.get(i).get("parentMenuId"))) {
					sidebar.add(temp.get(i));
					if (request.getParameter("menuId").equals(temp.get(i).get("menuId"))) {
						targetController = temp.get(i).get("controllerName").toString();
					}
				}
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", menu);
		mav.addObject("sidebar", sidebar);
		mav.setViewName("forward:/" + targetController);
		return mav;
	}
}
