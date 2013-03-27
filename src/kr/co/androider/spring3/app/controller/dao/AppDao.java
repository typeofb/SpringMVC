package kr.co.androider.spring3.app.controller.dao;

import java.util.List;
import java.util.Map;

import kr.co.androider.spring3.app.controller.bean.AppBean;

public interface AppDao {
//    public List<AppBean> retrieveApp(@Param("appPkgName") String appPkgName, @Param("appName") String appName);
    public List<AppBean> retrieveApp(Map<String, String> map);
    
    public void createApp(AppBean data);
}