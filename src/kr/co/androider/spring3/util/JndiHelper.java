// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JndiHelper.java

package kr.co.androider.spring3.util;

import java.util.Hashtable;

import javax.naming.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @deprecated Class JndiHelper is deprecated
 */

public class JndiHelper
{

    private JndiHelper()
    {
    }

    public static Object lookup(String jndiName)
        throws NamingException
    {
        return lookupJndiObject(jndiName);
    }

    public static Object lookup(String jndiName, Hashtable env)
        throws NamingException
    {
        return lookupJndiObject(jndiName, env);
    }

    public static Object lookup(String jndiName, String jndiEnvKey, String jndiEnvValue)
        throws NamingException
    {
        Hashtable env = new Hashtable();
        env.put(jndiEnvKey, jndiEnvValue);
        return lookup(jndiName, env);
    }

    private static Object lookupJndiObject(String jndiName)
        throws NamingException
    {
        Context initialContext = new InitialContext();
        Object object = null;
        try
        {
            object = initialContext.lookup(jndiName);
            if(logger.isDebugEnabled())
                logger.debug("Lookup resource from Initial Context: " + jndiName + " - success.[" + object + "]");
        }
        catch(NameNotFoundException e)
        {
            if(logger.isDebugEnabled())
                logger.debug("Lookup resource from Initial Context: " + jndiName + " - failed.", e);
        }
        if(object == null)
            try
            {
                Context context = (Context)initialContext.lookup("java:/comp/env");
                object = context.lookup(jndiName);
                if(logger.isDebugEnabled())
                    logger.debug("Lookup resource from Environment Context(java:/comp/env): " + jndiName + " - success.[" + object + "]");
            }
            catch(NameNotFoundException e)
            {
                if(logger.isDebugEnabled())
                    logger.debug("Lookup resource from Environment Context(java:/comp/env): " + jndiName + " - failed.", e);
            }
        return object;
    }

    private static Object lookupJndiObject(String jndiName, Hashtable env)
        throws NamingException
    {
        Context initialContext = new InitialContext(env);
        Object object = initialContext.lookup(jndiName);
        return object;
    }

    static Class _mthclass$(String x0) throws Throwable
    {
        try
        {
            return Class.forName(x0);
        }
        catch(ClassNotFoundException x1)
        {
            throw (new NoClassDefFoundError()).initCause(x1);
        }
    }

    private static Logger logger;

    static 
    {
        logger = LoggerFactory.getLogger(kr.co.androider.spring3.util.JndiHelper.class);
    }
}
