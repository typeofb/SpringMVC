package kr.co.androider.spring3.common.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.androider.spring3.common.vo.NavigatorVO;

public class NavigatorDao {

	public List<NavigatorVO> retrieveMenu() {
		NavigatorVO navi1 = new NavigatorVO();
		navi1.setMenuId(1);
		navi1.setMenuName("User Mgmt");
		navi1.setParentMenuId(0);
		navi1.setControllerName("hello.do");
		NavigatorVO navi2 = new NavigatorVO();
		navi2.setMenuId(2);
		navi2.setMenuName("Service Mgmt");
		navi2.setParentMenuId(0);
		navi2.setControllerName("app.do");
		NavigatorVO navi3 = new NavigatorVO();
		navi3.setMenuId(3);
		navi3.setMenuName("Service Monitoring");
		navi3.setParentMenuId(0);
		navi3.setControllerName("contact.do");
		NavigatorVO navi4 = new NavigatorVO();
		navi4.setMenuId(4);
		navi4.setMenuName("Common Mgmt");
		navi4.setParentMenuId(0);
		navi4.setControllerName("report.do");
		
		List<NavigatorVO> resultList = new ArrayList<NavigatorVO>();
		resultList.add(navi1);
		resultList.add(navi2);
		resultList.add(navi3);
		resultList.add(navi4);
		return resultList;
	}
	
	public List<NavigatorVO> retrieveSidebar() {
		NavigatorVO navi1 = new NavigatorVO();
		navi1.setMenuId(1001);
		navi1.setMenuName("Say Hello");
		navi1.setParentMenuId(1);
		navi1.setControllerName("hello.do");
		NavigatorVO navi2 = new NavigatorVO();
		navi2.setMenuId(1002);
		navi2.setMenuName("Retrieve App");
		navi2.setParentMenuId(2);
		navi2.setControllerName("app.do");
		NavigatorVO navi3 = new NavigatorVO();
		navi3.setMenuId(1003);
		navi3.setMenuName("Contact");
		navi3.setParentMenuId(3);
		navi3.setControllerName("contact.do");
		NavigatorVO navi4 = new NavigatorVO();
		navi4.setMenuId(1004);
		navi4.setMenuName("Report Page");
		navi4.setParentMenuId(4);
		navi4.setControllerName("report.do");
		NavigatorVO navi5 = new NavigatorVO();
		navi5.setMenuId(1005);
		navi5.setMenuName("SMS 발송");
		navi5.setParentMenuId(1);
		navi5.setControllerName("sms.do");
		NavigatorVO navi6 = new NavigatorVO();
		navi6.setMenuId(1006);
		navi6.setMenuName("사원 정보");
		navi6.setParentMenuId(1);
		navi6.setControllerName("employee.do");
		NavigatorVO navi7 = new NavigatorVO();
		navi7.setMenuId(1007);
		navi7.setMenuName("Highcharts");
		navi7.setParentMenuId(4);
		navi7.setControllerName("highcharts.do");
		
		List<NavigatorVO> resultList = new ArrayList<NavigatorVO>();
		resultList.add(navi1);
		resultList.add(navi2);
		resultList.add(navi3);
		resultList.add(navi4);
		resultList.add(navi5);
		resultList.add(navi6);
		resultList.add(navi7);
		return resultList;
	}
}
