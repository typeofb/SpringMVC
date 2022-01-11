package kr.co.androider.spring3.serviceMgmt.dao;

import java.util.List;
import java.util.Map;

import kr.co.androider.spring3.serviceMgmt.vo.AppVo;

public interface AppDao {
//    public List<AppVo> retrieveApp(@Param("appPkgName") String appPkgName, @Param("appName") String appName);
    public List<AppVo> retrieveApp(Map<String, String> map);
    
    public void createApp(AppVo data);
}