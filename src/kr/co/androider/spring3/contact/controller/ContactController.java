package kr.co.androider.spring3.contact.controller;

import kr.co.androider.spring3.contact.controller.bean.ContactBean;
import kr.co.androider.spring3.contact.controller.service.IContactService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private IContactService iContactService;
    
    @RequestMapping("/contact")
    public ModelAndView showContact() {
        logger.info("console - debug level /contact! ");
        
        return new ModelAndView("contact", "command", new ContactBean());
    }
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact") ContactBean contactBean, BindingResult result) {
        
        ContactBean contact = new ContactBean();
        contact = iContactService.changeInfo(contactBean);
        
        return new ModelAndView("contact", "command", contact);
    }
}