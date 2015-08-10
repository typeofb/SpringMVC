// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FrameworkException.java

package kr.co.androider.spring3.infra.exception;


// Referenced classes of package hanwha.hone.runtime.infra.exception:
//            HoneException

public class FrameworkException extends HoneException
{

    public FrameworkException()
    {
        super("\uD504\uB808\uC784\uC6CC\uD06C \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.");
    }

    public FrameworkException(String message)
    {
        super(message);
    }

    public FrameworkException(Throwable t)
    {
        super("\uD504\uB808\uC784\uC6CC\uD06C \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", t);
    }

    public FrameworkException(String message, Throwable t)
    {
        super(message, t);
    }

    private static final long serialVersionUID = 0x8375aad2a5aaf7a3L;
    public static final String DEFAULT_ERROR_MESSAGE = "\uD504\uB808\uC784\uC6CC\uD06C \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.";
}
