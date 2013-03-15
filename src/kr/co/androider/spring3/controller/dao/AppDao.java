package kr.co.androider.spring3.controller.dao;

import java.util.List;

import kr.co.androider.spring3.controller.bean.AppBean;;

public interface AppDao {
    public List<AppBean> retrieveApp();
}
