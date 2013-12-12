package kr.co.androider.spring3.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigatorVO {
	
	public NavigatorVO() {}
	
	private int menuId;
	private String menuName;
	private String menuDescription;
	private int menuLevel;
	private int menuSequence;
	private int parentMenuId;
	private String useFlag;
	private String createUserId;
	private String createDate;
	private String lastUpdateUserId;
	private String lastUpdateDate;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
	public int getMenuSequence() {
		return menuSequence;
	}
	public void setMenuSequence(int menuSequence) {
		this.menuSequence = menuSequence;
	}
	public int getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveMenu() {
		List<Map> menu = new ArrayList<Map>();
		
		Map<String, String> mapA1 = new HashMap<String, String>();
		mapA1.put("menuId", "0001");
		mapA1.put("menuName", "User Mgmt");
		mapA1.put("parentMenuId", null);
		mapA1.put("controllerName", "hello.do");
		Map<String, String> mapA2 = new HashMap<String, String>();
		mapA2.put("menuId", "0002");
		mapA2.put("menuName", "Service Mgmt");
		mapA2.put("parentMenuId", null);
		mapA2.put("controllerName", "app.do");
		Map<String, String> mapA3 = new HashMap<String, String>();
		mapA3.put("menuId", "0003");
		mapA3.put("menuName", "Service Monitoring");
		mapA3.put("parentMenuId", null);
		mapA3.put("controllerName", "contact.do");
		Map<String, String> mapA4 = new HashMap<String, String>();
		mapA4.put("menuId", "0004");
		mapA4.put("menuName", "Common Mgmt");
		mapA4.put("parentMenuId", null);
		mapA4.put("controllerName", "report.do");
		menu.add(mapA1);
		menu.add(mapA2);
		menu.add(mapA3);
		menu.add(mapA4);
		
		return menu;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveSidebar() {
		List<Map> sidebar = new ArrayList<Map>();
		
		Map<String, String> mapB1 = new HashMap<String, String>();
		mapB1.put("menuId", "1001");
		mapB1.put("menuName", "Say Hello");
		mapB1.put("parentMenuId", "0001");
		mapB1.put("controllerName", "hello.do");
		Map<String, String> mapB2 = new HashMap<String, String>();
		mapB2.put("menuId", "1002");
		mapB2.put("menuName", "Retrieve App");
		mapB2.put("parentMenuId", "0002");
		mapB2.put("controllerName", "app.do");
		Map<String, String> mapB3 = new HashMap<String, String>();
		mapB3.put("menuId", "1003");
		mapB3.put("menuName", "Contact");
		mapB3.put("parentMenuId", "0003");
		mapB3.put("controllerName", "contact.do");
		Map<String, String> mapB4 = new HashMap<String, String>();
		mapB4.put("menuId", "1004");
		mapB4.put("menuName", "Report Page");
		mapB4.put("parentMenuId", "0004");
		mapB4.put("controllerName", "report.do");
		Map<String, String> mapB5 = new HashMap<String, String>();
		mapB5.put("menuId", "1005");
		mapB5.put("menuName", "SMS 발송");
		mapB5.put("parentMenuId", "0001");
		mapB5.put("controllerName", "sms.do");
		Map<String, String> mapB6 = new HashMap<String, String>();
		mapB6.put("menuId", "1006");
		mapB6.put("menuName", "사원 정보");
		mapB6.put("parentMenuId", "0001");
		mapB6.put("controllerName", "employee.do");
		Map<String, String> mapB7 = new HashMap<String, String>();
		mapB7.put("menuId", "1007");
		mapB7.put("menuName", "Highcharts");
		mapB7.put("parentMenuId", "0004");
		mapB7.put("controllerName", "highcharts.do");
		sidebar.add(mapB1);
		sidebar.add(mapB2);
		sidebar.add(mapB3);
		sidebar.add(mapB4);
		sidebar.add(mapB5);
		sidebar.add(mapB6);
		sidebar.add(mapB7);
		
		return sidebar;
	}
}
