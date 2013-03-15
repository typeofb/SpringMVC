package kr.co.androider.spring3.app.controller;

import java.util.List;

import kr.co.androider.spring3.app.controller.bean.AppBean;
import kr.co.androider.spring3.app.controller.dao.AppDao;

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
        List<AppBean> list = appDao.retrieveApp("com.lge.lglink.group", "Link Group");
        for (int i = 0; i < list.size(); i++) {
            logger.debug(list.get(i).getAppId());
            logger.debug(list.get(i).getAppPkgName());
            logger.debug(list.get(i).getAppSize());
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("app");
        mv.addObject("msg", list.get(0).getAppPkgName());

        return mv;
    }
}