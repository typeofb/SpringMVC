// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JdbcUtils.java

package kr.co.androider.spring3.util;

import java.math.BigDecimal;
import java.util.Date;

public class JdbcUtils extends org.springframework.jdbc.support.JdbcUtils
{

    public JdbcUtils()
    {
    }

    public static double convertToDouble(Object value, int type)
    {
        if(8 == type)
            return ((Double)value).doubleValue();
        if(4 == type)
            return ((Integer)value).doubleValue();
        if(6 == type)
            return ((Float)value).doubleValue();
        if(5 == type)
            return ((Short)value).doubleValue();
        if(-5 == type)
            return ((Long)value).doubleValue();
        if(3 == type || 2 == type)
            return ((BigDecimal)value).doubleValue();
        else
            throw new IllegalArgumentException("\uC608\uC0C1\uCE58 \uBABB\uD55C \uC22B\uC790 \uB370\uC774\uD130\uAC00 \uB4E4\uC5B4 \uC788\uC2B5\uB2C8\uB2E4.[data: " + value.toString() + ", jdbc type:" + type + "]");
    }

    public static Date convertToDate(Object value, int type)
    {
        if(value instanceof Date)
            return (Date)value;
        if(value instanceof java.sql.Date)
            return new Date(((java.sql.Date)value).getTime());
        else
            throw new IllegalArgumentException("\uC608\uC0C1\uCE58 \uBABB\uD55C \uB0A0\uC9DC \uD615\uC2DD \uB370\uC774\uD130\uAC00 \uB4E4\uC5B4 \uC788\uC2B5\uB2C8\uB2E4.[data: " + value.toString() + ", jdbc type:" + type + "]");
    }
}
