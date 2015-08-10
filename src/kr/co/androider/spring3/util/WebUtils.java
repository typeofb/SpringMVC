// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WebUtils.java

package hanwha.hone.runtime.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import org.springframework.util.Assert;

// Referenced classes of package hanwha.hone.runtime.util:
//            StringUtils

public class WebUtils extends org.springframework.web.util.WebUtils
{

    public WebUtils()
    {
    }

    public static Map bindQueryStringToMap(String queryString)
    {
        HashMap bindedMap = new HashMap();
        String values[] = StringUtils.splitByRegExp(queryString, "&");
        for(int i = 0; i < values.length; i++)
        {
            String keyAndValue[] = StringUtils.splitByRegExp(values[i], "=");
            if(!StringUtils.hasLength(keyAndValue[0]))
                continue;
            String value = "";
            if(keyAndValue.length > 1)
            {
                value = StringUtils.replace(keyAndValue[1], "\"", "");
                value = StringUtils.replace(value, "'", "");
            }
            bindedMap.put(keyAndValue[0], value);
        }

        return bindedMap;
    }

    public static boolean hasParameterWithPrefix(ServletRequest request, String prefix)
    {
        Enumeration paramNames = request.getParameterNames();
        if(!StringUtils.hasText(prefix))
            return false;
        boolean result = false;
        do
        {
            if(paramNames == null || !paramNames.hasMoreElements())
                break;
            String paramName = (String)paramNames.nextElement();
            if("".equals(prefix) || paramName.startsWith(prefix))
            {
                String values[] = request.getParameterValues(paramName);
                if(values != null || values.length > 0)
                    result = true;
            }
        } while(true);
        return result;
    }

    public static void setWebAppRootSystemProperty(ServletContext servletContext)
        throws IllegalStateException
    {
        Assert.notNull(servletContext, "ServletContext must not be null");
        String root = servletContext.getRealPath("/");
        if(root == null)
        {
            root = resolveRootKey(servletContext);
            if(root == null)
                throw new IllegalStateException("Cannot set web app root system property when WAR file is not expanded");
        }
        String param = servletContext.getInitParameter("webAppRootKey");
        String key = param == null ? "webapp.root" : param;
        String oldValue = System.getProperty(key);
        if(oldValue != null && !StringUtils.pathEquals(oldValue, root))
        {
            throw new IllegalStateException("Web app root system property already set to different value: '" + key + "' = [" + oldValue + "] instead of [" + root + "] - " + "Choose unique values for the 'webAppRootKey' context-param in your web.xml files!");
        } else
        {
            System.setProperty(key, root);
            servletContext.log("Set web app root system property: '" + key + "' = [" + root + "]");
            return;
        }
    }

    private static String resolveRootKey(ServletContext servletContext)
    {
        return servletContext.getInitParameter("contextRootKey");
    }

    public static final String CONTEXT_ROOT_KEY = "contextRootKey";
}
