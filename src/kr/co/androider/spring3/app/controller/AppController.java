package kr.co.androider.spring3.app.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import kr.co.androider.spring3.app.vo.AppVo;
import kr.co.androider.spring3.app.dao.AppDao;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController extends SqlSessionDaoSupport {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/app")
    public ModelAndView app() {
        logger.info("console - debug level /app!");
        
        AppDao appDao = getSqlSession().getMapper(AppDao.class);
        
        // SELECT
        Map<String, String> map = new HashMap<String, String>();
        map.put("appPkgName", "com.lge.lglink.group");
        map.put("appName", "Link Group");
        List<AppVo> list = appDao.retrieveApp(map);
        for (int i = 0; i < list.size(); i++) {
            logger.debug(list.get(i).getAppId());
            logger.debug(list.get(i).getAppPkgName());
            logger.debug(list.get(i).getAppSize());
        }
        
        // INSERT
        AppVo talkData = new AppVo();
        talkData.setAppId(UUID.randomUUID().toString());
        talkData.setAppName("Link Talk");
        talkData.setAppPkgName("com.lge.lglink.talk");
        talkData.setAppVerCode("100");
        talkData.setAppVerName("1.0.100 Beta");
        talkData.setUseFlag("Y");
        talkData.setGenUsrId("cpmappuser");
        talkData.setLastChgUsrId("cpmappadmin");
        appDao.createApp(talkData);
        
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("app");
        mv.addObject("appList", list);

        return mv;
    }
}