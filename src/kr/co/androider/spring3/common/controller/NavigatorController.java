package kr.co.androider.spring3.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.common.dao.NavigatorDao;
import kr.co.androider.spring3.common.vo.NavigatorVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigatorController {
	
	@RequestMapping("/navigator")
	public ModelAndView menu(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("menuId"));
		System.out.println(request.getParameter("parentMenuId"));
		
		String targetController = null;
		List<NavigatorVO> menu = new ArrayList<NavigatorVO>();
		List<NavigatorVO> sidebar = new ArrayList<NavigatorVO>();
		
		// 초기 화면
		if (request.getParameter("menuId") == null && request.getParameter("parentMenuId") == null) {
			menu = new NavigatorDao().retrieveMenu();
			
			List<NavigatorVO> temp = new NavigatorDao().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getParentMenuId() == 1) {
					sidebar.add(temp.get(i));
					if (temp.get(i).getMenuId() == 1001) {
						targetController = temp.get(i).getControllerName();
					}
				}
			}
		}
		
		// 헤더 메뉴 클릭
		else if (Integer.parseInt(request.getParameter("parentMenuId")) == 0) {
			menu = new NavigatorDao().retrieveMenu();
			
			List<NavigatorVO> temp = new NavigatorDao().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if (Integer.parseInt(request.getParameter("menuId")) == temp.get(i).getParentMenuId()) {
					sidebar.add(temp.get(i));
				}
			}
			
			for (int i = 0; i < menu.size(); i++) {
				if (Integer.parseInt(request.getParameter("menuId")) == menu.get(i).getMenuId()) {
					targetController = menu.get(i).getControllerName();
				}
			}
		}
		
		// 사이드바 클릭
		else {
			menu = new NavigatorDao().retrieveMenu();
			
			List<NavigatorVO> temp = new NavigatorDao().retrieveSidebar();
			for (int i = 0; i < temp.size(); i++) {
				if (Integer.parseInt(request.getParameter("parentMenuId")) == temp.get(i).getParentMenuId()) {
					sidebar.add(temp.get(i));
					if (Integer.parseInt(request.getParameter("menuId")) == temp.get(i).getMenuId()) {
						targetController = temp.get(i).getControllerName();
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
