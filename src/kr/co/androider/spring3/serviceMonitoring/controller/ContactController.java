package kr.co.androider.spring3.serviceMonitoring.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.androider.spring3.serviceMonitoring.service.IContactService;
import kr.co.androider.spring3.serviceMonitoring.vo.ContactVo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    
    private Logger logger = Logger.getLogger(getClass());
    private SaveToken saveToken = new SaveToken();
    
    @Autowired
    private IContactService iContactService;
    
    @RequestMapping("/contact")
    public String showContact(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	
        logger.info("console - debug level /contact! ");
        
        // 토큰 생성 - Cross-Site Request Forgery(CSRF)
        saveToken.setToken(request);
        
        List<String> hobby = new ArrayList<String>();
        hobby.add("농구");
        hobby.add("헬스");
        hobby.add("자전거");
        hobby.add("기타");
        modelMap.put("hobbyList", hobby);
        
        ContactVo contactVo = new ContactVo();
        List<String> hobbyDefault = new ArrayList<String>();
        hobbyDefault.add("헬스");
        hobbyDefault.add("자전거");
        contactVo.setHobbies(hobbyDefault);
        
        Map<String,String> country = new LinkedHashMap<String,String>();
        country.put("US", "United Stated");
        country.put("CHINA", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        modelMap.put("countryList", country);
        
        contactVo.setCountry("SG");
        
        modelMap.put("command", contactVo);
        
        return "serviceMonitoring/contact";
    }
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") ContactVo contactVo, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        
    	logger.info("console - debug level /addContact! ");
    	
        // 토큰 비교 - LoginSessionCheckInterceptor preHandle에서 처리
//        if (saveToken.isValid(request, response)) {
//        	logger.debug("true");
//    	} else {
//    		logger.debug("false");
////    		return new ModelAndView("forward:/contact.do");
//        	return new ModelAndView("redirect:/");
//    	}
        
        ContactVo contact = new ContactVo();
        contact = iContactService.changeInfo(contactVo);
        
        modelMap.put("command", contact);
        
        return "serviceMonitoring/addContact";
    }
}