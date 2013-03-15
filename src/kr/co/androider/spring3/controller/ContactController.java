package kr.co.androider.spring3.controller;

import java.util.List;

import kr.co.androider.spring3.controller.bean.AppBean;
import kr.co.androider.spring3.controller.dao.AppDao;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController extends SqlSessionDaoSupport {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/contact")
    public ModelAndView contacts() {
        logger.info("console - debug level /contact!");
        
        AppDao appDao = getSqlSession().getMapper(AppDao.class);
        List<AppBean> list = appDao.retrieveApp("com.lge.lglink.group", "Link Group");
        for (int i = 0; i < list.size(); i++) {
            logger.debug(list.get(i).getAppId());
            logger.debug(list.get(i).getAppPkgName());
            logger.debug(list.get(i).getAppSize());
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contact");
        mv.addObject("msg", list.get(0).getAppPkgName());

        return mv;
    }
}