package kr.co.androider.spring3.common.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.androider.spring3.common.vo.NavigatorVo;

public class NavigatorDao {

	public List<NavigatorVo> retrieveMenu() {
		NavigatorVo navi1 = new NavigatorVo();
		navi1.setMenuId(1);
		navi1.setMenuName("User Mgmt");
		navi1.setParentMenuId(0);
		navi1.setControllerName("hello.do");
		NavigatorVo navi2 = new NavigatorVo();
		navi2.setMenuId(2);
		navi2.setMenuName("Service Mgmt");
		navi2.setParentMenuId(0);
		navi2.setControllerName("app.do");
		NavigatorVo navi3 = new NavigatorVo();
		navi3.setMenuId(3);
		navi3.setMenuName("Service Monitoring");
		navi3.setParentMenuId(0);
		navi3.setControllerName("contact.do");
		NavigatorVo navi4 = new NavigatorVo();
		navi4.setMenuId(4);
		navi4.setMenuName("Common Mgmt");
		navi4.setParentMenuId(0);
		navi4.setControllerName("report.do");
		
		List<NavigatorVo> resultList = new ArrayList<NavigatorVo>();
		resultList.add(navi1);
		resultList.add(navi2);
		resultList.add(navi3);
		resultList.add(navi4);
		return resultList;
	}
	
	public List<NavigatorVo> retrieveSidebar() {
		NavigatorVo navi1 = new NavigatorVo();
		navi1.setMenuId(1001);
		navi1.setMenuName("Say Hello");
		navi1.setParentMenuId(1);
		navi1.setControllerName("hello.do");
		NavigatorVo navi2 = new NavigatorVo();
		navi2.setMenuId(1002);
		navi2.setMenuName("Retrieve App");
		navi2.setParentMenuId(2);
		navi2.setControllerName("app.do");
		NavigatorVo navi3 = new NavigatorVo();
		navi3.setMenuId(1003);
		navi3.setMenuName("Contact");
		navi3.setParentMenuId(3);
		navi3.setControllerName("contact.do");
		NavigatorVo navi4 = new NavigatorVo();
		navi4.setMenuId(1004);
		navi4.setMenuName("Report Page");
		navi4.setParentMenuId(4);
		navi4.setControllerName("report.do");
		NavigatorVo navi5 = new NavigatorVo();
		navi5.setMenuId(1005);
		navi5.setMenuName("SMS 발송");
		navi5.setParentMenuId(1);
		navi5.setControllerName("sms.do");
		NavigatorVo navi6 = new NavigatorVo();
		navi6.setMenuId(1006);
		navi6.setMenuName("사원 정보");
		navi6.setParentMenuId(1);
		navi6.setControllerName("employee.do");
		NavigatorVo navi7 = new NavigatorVo();
		navi7.setMenuId(1007);
		navi7.setMenuName("Highcharts");
		navi7.setParentMenuId(4);
		navi7.setControllerName("highcharts.do");
		
		List<NavigatorVo> resultList = new ArrayList<NavigatorVo>();
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
