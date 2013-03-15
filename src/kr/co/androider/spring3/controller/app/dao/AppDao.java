package kr.co.androider.spring3.controller.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.androider.spring3.controller.app.bean.AppBean;;

public interface AppDao {
    public List<AppBean> retrieveApp(@Param("appPkgName") String appPkgName, @Param("appName") String appName);
}
