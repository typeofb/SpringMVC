// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CalendarUtils.java

package kr.co.androider.spring3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.StringUtils;

public class CalendarUtils extends DateUtils
{

    public CalendarUtils()
    {
    }

    public static String getFormattedDate(String pattern, Date date)
    {
        if(date == null)
            return null;
        if(!StringUtils.hasText(pattern))
            pattern = "yyyyMMddHHmmssSSS";
        return (new SimpleDateFormat(pattern)).format(date);
    }

    public static Date getDate(String pattern, String date)
    {
        if(date == null)
            return null;
        if(!StringUtils.hasText(pattern))
            pattern = "yyyyMMddHHmmssSSS";
        try
        {
            return (new SimpleDateFormat(pattern)).parse(date);
        }
        catch(ParseException e)
        {
            throw new IllegalArgumentException("\uC8FC\uC5B4\uC9C4 \uB0A0\uC9DC\uB97C \uD30C\uC2F1\uD560 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4. : [pattern : " + pattern + " / date : " + date + " ]");
        }
    }

    public static long getTimesSecond(Date startDate, Date endDate)
    {
        if(startDate == null || endDate == null)
            throw new IllegalArgumentException("\uC8FC\uC5B4\uC9C4 \uB0A0\uC9DC\uAC00 null \uC785\uB2C8\uB2E4.");
        if(startDate.compareTo(endDate) > 0)
            throw new IllegalArgumentException("\uBE44\uAD50\uB418\uB294 \uB0A0\uC9DC\uC758 \uC120\uD6C4\uAC00 \uC798\uBABB\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
        else
            return (long)Math.round((float)(endDate.getTime() - startDate.getTime()) / 1000F);
    }

    public static Date convertTimezone(Date date, TimeZone tz)
    {
        if(date == null)
            throw new IllegalArgumentException("\uC8FC\uC5B4\uC9C4 \uB0A0\uC9DC\uAC00 null \uC785\uB2C8\uB2E4.");
        if(tz == null)
        {
            throw new IllegalArgumentException("\uC8FC\uC5B4\uC9C4 TimeZone\uC774 null \uC785\uB2C8\uB2E4.");
        } else
        {
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("UTC"));
            cal.setTime(date);
            cal.setTimeZone(tz);
            return cal.getTime();
        }
    }

    private static final String DATE_PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    private static final String DEFAULT_DATE_PATTERN = "yyyyMMddHHmmssSSS";
}
