package kr.co.androider.spring3.contact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.contact.vo.ContactVo;
import kr.co.androider.spring3.contact.service.IContactService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    
    private Logger logger = Logger.getLogger(getClass());
    private SaveToken saveToken = new SaveToken();
    
    @Autowired
    private IContactService iContactService;
    
    @RequestMapping("/contact")
    public ModelAndView showContact(HttpServletRequest request, HttpServletResponse response) {
    	
        logger.info("console - debug level /contact! ");
        
        // 토큰 생성
        saveToken.setToken(request);
        
        return new ModelAndView("contact", "command", new ContactVo());
    }
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact") ContactVo ContactVo, HttpServletRequest request, HttpServletResponse response) {
        
    	logger.info("console - debug level /addContact! ");
    	
        // 토큰 비교
        if (saveToken.isValid(request, response)) {
        	logger.debug("true");
    	} else {
    		logger.debug("false");
//    		return new ModelAndView("forward:/contact.do");
        	return new ModelAndView("redirect:/");
    	}
        
        ContactVo contact = new ContactVo();
        contact = iContactService.changeInfo(ContactVo);
        
        return new ModelAndView("contact", "command", contact);
    }
}