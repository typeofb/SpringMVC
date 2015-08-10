// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagUtils.java

package hanwha.hone.runtime.util;


// Referenced classes of package hanwha.hone.runtime.util:
//            StringUtils

public class TagUtils
{

    public TagUtils()
    {
    }

    public static final String escapeEntities(String text)
    {
        if(!StringUtils.hasLength(text))
            return text;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(c == '<')
            {
                sb.append("&lt;");
                continue;
            }
            if(c == '>')
            {
                sb.append("&gt;");
                continue;
            }
            if(c == '"')
            {
                sb.append("&#034;");
                continue;
            }
            if(c == '\'')
            {
                sb.append("&#039;");
                continue;
            }
            if(c == '&')
                sb.append("&amp;");
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
