package kr.co.androider.spring3.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogoutController {
    
    @RequestMapping("/logout")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        RedirectView rv = new RedirectView(request.getContextPath());
        rv.setExposeModelAttributes(false);
        return new ModelAndView(rv);
    }
}