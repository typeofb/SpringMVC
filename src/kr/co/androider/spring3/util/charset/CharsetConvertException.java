// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CharsetConvertException.java

package hanwha.hone.runtime.util.charset;

import hanwha.hone.runtime.infra.exception.FrameworkException;

public class CharsetConvertException extends FrameworkException
{

    public CharsetConvertException()
    {
        super("Charset \uBCC0\uD658 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.");
    }

    public CharsetConvertException(String message)
    {
        super(message);
    }

    public CharsetConvertException(String from, String to)
    {
        super(buildErrorMessage(from, to));
    }

    public CharsetConvertException(Throwable t)
    {
        super("Charset \uBCC0\uD658 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", t);
    }

    public CharsetConvertException(String message, Throwable t)
    {
        super(message, t);
    }

    public CharsetConvertException(String from, String to, Throwable t)
    {
        super(buildErrorMessage(from, to), t);
    }

    private static String buildErrorMessage(String from, String to)
    {
        return "Charset \uBCC0\uD658[ " + from + " -> " + to + " ] \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.";
    }

    private static final long serialVersionUID = 0xbc6742830b5a8269L;
    private static final String DEFAULT_ERROR_MESSAGE = "Charset \uBCC0\uD658 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.";
}
