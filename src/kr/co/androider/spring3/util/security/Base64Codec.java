// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Base64Codec.java

package kr.co.androider.spring3.util.security;

import kr.co.androider.spring3.util.StringUtils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Codec
{

    public Base64Codec()
    {
    }

    public static String encodeToString(byte input[])
    {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(input);
    }

    public static byte[] encodeToByte(byte input[])
    {
        return encodeToString(input).getBytes();
    }

    public static String encodeToString(String input)
    {
        checkValidArgument(input);
        return encodeToString(input.getBytes());
    }

    public static byte[] encodeToByte(String input)
    {
        checkValidArgument(input);
        return encodeToString(input.getBytes()).getBytes();
    }

    public static String encodeBufferToString(byte input[])
    {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeBuffer(input);
    }

    public static byte[] encodeBufferToByte(byte input[])
    {
        return encodeBufferToString(input).getBytes();
    }

    public static String encodeBufferToString(String input)
    {
        checkValidArgument(input);
        return encodeBufferToString(input.getBytes());
    }

    public static byte[] encodeBufferToByte(String input)
    {
        checkValidArgument(input);
        return encodeBufferToString(input.getBytes()).getBytes();
    }

    public static byte[] decodeToByte(String input)
    {
        BASE64Decoder decoder = new BASE64Decoder();
        byte decodedValue[] = null;
        try
        {
            decodedValue = decoder.decodeBuffer(input);
        }
        catch(IOException e)
        {
            logger.error("IO \uC608\uC678\uAC00 \uBC1C\uC0DD\uD588\uC2B5\uB2C8\uB2E4.", e);
        }
        return decodedValue;
    }

    public static String decodeToString(String input)
    {
        return new String(decodeToByte(input));
    }

    private static void checkValidArgument(String input)
    {
        if(!StringUtils.hasLength(input))
            throw new IllegalArgumentException("\uC785\uB825 \uC778\uC790\uAC00 \uC720\uD6A8\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
        else
            return;
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

    private static final Logger logger;

    static 
    {
        logger = LoggerFactory.getLogger(kr.co.androider.spring3.util.security.Base64Codec.class);
    }
}
