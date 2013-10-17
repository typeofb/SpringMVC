package kr.co.androider.spring3.serviceMgmt.dao;

import java.util.List;
import java.util.Map;

import kr.co.androider.spring3.serviceMgmt.vo.AppVO;

public interface AppDao {
//    public List<AppVO> retrieveApp(@Param("appPkgName") String appPkgName, @Param("appName") String appName);
    public List<AppVO> retrieveApp(Map<String, String> map);
    
    public void createApp(AppVO data);
}