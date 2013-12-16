package kr.co.androider.spring3.serviceMgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import kr.co.androider.spring3.serviceMgmt.dao.AppDao;
import kr.co.androider.spring3.serviceMgmt.vo.AppVO;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController extends SqlSessionDaoSupport {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	DataSourceTransactionManager txManager;

	@RequestMapping("/app")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ModelAndView app() {
		logger.info("console - debug level /app!");

		AppDao appDao = getSqlSession().getMapper(AppDao.class);

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("app-transaction");
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);

		// SELECT
		Map<String, String> map = new HashMap<String, String>();
		map.put("appPkgName", "com.lge.lglink.group");
		map.put("appName", "Link Group");
		List<AppVO> list = appDao.retrieveApp(map);
		for (int i = 0; i < list.size(); i++) {
			logger.debug(list.get(i).getAppId());
			logger.debug(list.get(i).getAppPkgName());
			logger.debug(list.get(i).getAppSize());
		}

		try {
			// INSERT
			AppVO talkData = new AppVO();
			talkData.setAppId(UUID.randomUUID().toString());
			talkData.setAppName("Link Talk");
			talkData.setAppPkgName("com.lge.lglink.talk");
			talkData.setAppVerCode("100");
			talkData.setAppVerName("1.0.100 Beta");
			talkData.setUseFlag("Y");
			talkData.setGenUsrId("cpmappuser");
			talkData.setLastChgUsrId("cpmappadmin");
			appDao.createApp(talkData);

			// INSERT
			AppVO talkData2 = new AppVO();
			talkData2.setAppId(null);	// "APP_ID" NOT NULL
			talkData2.setAppName("Link Talk");
			talkData2.setAppPkgName("com.lge.lglink.talk");
			talkData2.setAppVerCode("100");
			talkData2.setAppVerName("1.0.100 Beta");
			talkData2.setUseFlag("Y");
			talkData2.setGenUsrId("cpmappuser");
			talkData2.setLastChgUsrId("cpmappadmin");
			appDao.createApp(talkData2);
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("appList", list);
		mv.setViewName("serviceMgmt/app");

		return mv;
	}
}