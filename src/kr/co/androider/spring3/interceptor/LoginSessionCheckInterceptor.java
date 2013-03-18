package kr.co.androider.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginSessionCheckInterceptor extends HandlerInterceptorAdapter {
    
    private Logger logger = Logger.getLogger(getClass());

    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception{
        
        logger.debug("##### interceptor #####");
        
        return true;
        
    }
}