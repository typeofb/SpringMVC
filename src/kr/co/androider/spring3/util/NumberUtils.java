// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NumberUtils.java

package kr.co.androider.spring3.util;

import java.text.DecimalFormat;

// Referenced classes of package kr.co.androider.spring3.util:
//            StringUtils

public class NumberUtils extends org.springframework.util.NumberUtils
{

    public NumberUtils()
    {
    }

    public static boolean isNumber(String s)
    {
        return StringUtils.matches(s, "[0-9]*");
    }

    public static boolean isRealNumber(String s)
    {
        return StringUtils.matches(s, "[0-9]*[\\.]?[0-9]*");
    }

    public static String formatMoney(String s)
    {
        return formatNumber(s, "#,##0");
    }

    public static String formatNumber(String s, String pattern)
    {
        if(!StringUtils.hasText(s) || !isRealNumber(s))
            return "";
        String result = null;
        try
        {
            result = formatNumber(parseNumber(s, java.lang.Double.class), pattern);
            return result;
        }
        catch(NumberFormatException nfe)
        {
            return s;
        }
    }

    public static String formatNumber(Number number)
    {
        return formatNumber(number, "#,##0");
    }

    public static String formatNumber(Number number, String pattern)
    {
        if(number == null)
            return "";
        String formattedString = null;
        if(!StringUtils.hasText(pattern))
            pattern = "#,##0";
        DecimalFormat df = new DecimalFormat(pattern);
        formattedString = df.format(number);
        return formattedString;
    }

    public static int hexStringToInt(String hex)
    {
        int value = 0;
        if(StringUtils.hasText(hex))
        {
            hex = hex.toLowerCase();
            if(hex.startsWith("0x"))
                hex = hex.substring(2);
            String max = "7fffffff";
            if(hex.length() > max.length() || hex.length() == max.length() && hex.charAt(0) > '7')
                throw new IllegalArgumentException("int\uC758 \uCD5C\uB300\uAC12(2147483647)\uC744 \uB118\uC5B4\uAC00\uB294 \uC218 \uC785\uB2C8\uB2E4.");
            char h[] = hex.toCharArray();
            for(int i = 0; i < h.length; i++)
                value = (int)((double)value + (double)hexToInt(h[i]) * Math.pow(16D, h.length - i - 1));

        }
        return value;
    }

    public static int hexToInt(char c)
    {
        if(c >= 'a' && c <= 'f')
            return (c - 97) + 10;
        if(c >= 'A' && c <= 'F')
            return (c - 65) + 10;
        if(c == '0')
            return 0;
        else
            return (c - 49) + 1;
    }
}
