// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TemplateUtils.java

package kr.co.androider.spring3.util.template;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.*;
import java.util.Map;
import org.springframework.util.StringUtils;

// Referenced classes of package kr.co.androider.spring3.util.template:
//            TemplateGenerateException

public abstract class TemplateUtils
{

    public TemplateUtils()
    {
    }

    public static void generate(String templatePath, Class loaderClass, Map model, OutputStream out)
    {
        try
        {
            generate(templatePath, loaderClass, model, ((Writer) (new OutputStreamWriter(out))));
        }
        catch(Exception e)
        {
            throw new TemplateGenerateException(e);
        }
    }

    public static void generate(String templatePath, Class loaderClass, Map model, Writer out)
    {
        if(!StringUtils.hasText(templatePath))
            throw new IllegalArgumentException("\uD15C\uD50C\uB9BF\uC758 \uD074\uB798\uC2A4 \uACBD\uB85C\uAC00 \uD544\uC694\uD569\uB2C8\uB2E4. - " + templatePath);
        if(model == null)
            throw new IllegalArgumentException("\uD15C\uD50C\uB9BF\uC744 \uC0DD\uC131\uD558\uAE30 \uC704\uD574\uC11C\uB294 \uBAA8\uB378\uC774 \uD544\uC694\uD569\uB2C8\uB2E4.");
        if(out == null)
            throw new IllegalArgumentException("\uD15C\uD50C\uB9BF\uC744 \uC0DD\uC131\uD560 \uC2A4\uD2B8\uB9BC\uC774 \uD544\uC694\uD569\uB2C8\uB2E4.");
        String PATH = "/";
        try
        {
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            Class lc = null;
            if(templatePath.startsWith("/"))
            {
                lc = loaderClass != null ? loaderClass : kr.co.androider.spring3.util.template.TemplateUtils.class;
            } else
            {
                if(loaderClass == null)
                    throw new IllegalArgumentException("\uD15C\uD50C\uB9BF\uC758 \uD074\uB798\uC2A4 \uACBD\uB85C\uAC00 \uC0C1\uB300\uACBD\uB85C\uC77C \uACBD\uC6B0\uC5D0\uB294 loaderClass\uAC00 \uD544\uC694\uD569\uB2C8\uB2E4.");
                lc = loaderClass;
            }
            int idx = templatePath.lastIndexOf("/");
            String prefix = templatePath.substring(0, idx);
            String templateFile = templatePath.substring(idx + 1);
            cfg.setTemplateLoader(new ClassTemplateLoader(lc, prefix));
            cfg.setNumberFormat("0.######");
            Template template = cfg.getTemplate(templateFile);
            template.process(model, out);
        }
        catch(Exception e)
        {
            throw new TemplateGenerateException(e);
        }
    }

    private static final String DEFAULT_ENCODING = "UTF-8";
}
