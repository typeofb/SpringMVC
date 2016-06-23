package kr.co.androider.spring3.serviceMonitoring.controller;

import java.util.LinkedHashMap;
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
    public String showContact(@ModelAttribute("contact") ContactVo contactVo, ModelMap modelMap, HttpServletRequest request) {
    	
        logger.info("console - debug level /contact! ");
        
        // 토큰 생성 - Cross-Site Request Forgery(CSRF)
        saveToken.setToken(request);
        
        Map<String, String> hobby = new LinkedHashMap<String, String>();
        hobby.put("Basketball", "농구");
        hobby.put("Health", "헬스");
        hobby.put("Bicycle", "자전거");
        hobby.put("Guitar", "기타");
        modelMap.put("hobbyList", hobby);
        
        Map<String, String> hobbyDefault = new LinkedHashMap<String, String>();
        hobbyDefault.put("Health", "헬스");
        hobbyDefault.put("Bicycle", "자전거");
        contactVo.setHobbies(hobbyDefault);
        
        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CHINA", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        modelMap.put("countryList", country);
        
        contactVo.setCountry("SG");
        
        return "serviceMonitoring/contact";
    }
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") ContactVo contactVo) {
        
    	logger.info("console - debug level /addContact! ");
    	
        // 토큰 비교 - LoginSessionCheckInterceptor preHandle에서 처리
//        if (saveToken.isValid(request, response)) {
//        	logger.debug("true");
//    	} else {
//    		logger.debug("false");
////    		return new ModelAndView("forward:/contact.do");
//        	return new ModelAndView("redirect:/");
//    	}
        
    	contactVo = iContactService.changeInfo(contactVo);
        
        return "serviceMonitoring/addContact";
    }
}