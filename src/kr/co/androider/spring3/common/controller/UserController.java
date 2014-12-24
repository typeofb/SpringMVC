package kr.co.androider.spring3.common.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class UserController {
	
	private Logger logger = Logger.getLogger(getClass());

	@ModelAttribute("userVo")
	public void index(Model model) {
		
		logger.debug("PreHandleController");
		model.addAttribute("user", "test");
	}
}
