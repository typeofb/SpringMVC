package kr.co.androider.spring3.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigatorVo {
	
	public NavigatorVo() {}
	
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
		mapA1.put("menuId", "1");
		mapA1.put("menuName", "User Mgmt");
		mapA1.put("parentMenuId", null);
		Map<String, String> mapA2 = new HashMap<String, String>();
		mapA2.put("menuId", "2");
		mapA2.put("menuName", "Service Mgmt");
		mapA2.put("parentMenuId", null);
		Map<String, String> mapA3 = new HashMap<String, String>();
		mapA3.put("menuId", "3");
		mapA3.put("menuName", "Service Monitoring");
		mapA3.put("parentMenuId", null);
		Map<String, String> mapA4 = new HashMap<String, String>();
		mapA4.put("menuId", "4");
		mapA4.put("menuName", "Common Mgmt");
		mapA4.put("parentMenuId", null);
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
		mapB1.put("menuId", "5");
		mapB1.put("menuName", "Say Hello");
		mapB1.put("parentMenuId", "1");
		Map<String, String> mapB2 = new HashMap<String, String>();
		mapB2.put("menuId", "6");
		mapB2.put("menuName", "Retrieve App");
		mapB2.put("parentMenuId", "1");
		Map<String, String> mapB3 = new HashMap<String, String>();
		mapB3.put("menuId", "7");
		mapB3.put("menuName", "Contact");
		mapB3.put("parentMenuId", "1");
		Map<String, String> mapB4 = new HashMap<String, String>();
		mapB4.put("menuId", "8");
		mapB4.put("menuName", "Report Page");
		mapB4.put("parentMenuId", "1");
		Map<String, String> mapB5 = new HashMap<String, String>();
		mapB5.put("menuId", "9");
		mapB5.put("menuName", "SMS 발송");
		mapB5.put("parentMenuId", "1");
		sidebar.add(mapB1);
		sidebar.add(mapB2);
		sidebar.add(mapB3);
		sidebar.add(mapB4);
		sidebar.add(mapB5);
		
		return sidebar;
	}
}
