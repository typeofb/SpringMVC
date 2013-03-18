package kr.co.androider.spring3.interceptor;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginSessionCheckInterceptor extends HandlerInterceptorAdapter {
    
    private Logger logger = Logger.getLogger(getClass());

    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception{
        
        logger.debug("##### interceptor #####");
        
        boolean isLoginDo = false;
        
        StringTokenizer st = new StringTokenizer(request.getRequestURL().toString(), "/");
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("login.do"))
                isLoginDo = true;
        }
        
        if (isLoginDo == true)
            return true;
        else {
            HttpSession session = request.getSession();
            if (session.getAttribute("token") == null)
                return false;
            else return true;
        }
    }
}