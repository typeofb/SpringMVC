// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HoneException.java

package kr.co.androider.spring3.infra.exception;


public abstract class HoneException extends RuntimeException
{

    public HoneException()
    {
        super("\uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.");
    }

    public HoneException(String message)
    {
        super(message);
    }

    public HoneException(Throwable t)
    {
        super("\uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", t);
    }

    public HoneException(String message, Throwable t)
    {
        super(message, t);
    }

    public static final String DEFAULT_ERROR_MESSAGE = "\uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.";
}
