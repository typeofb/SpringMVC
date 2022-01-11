// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TemplateGenerateException.java

package kr.co.androider.spring3.util.template;

import kr.co.androider.spring3.infra.exception.FrameworkException;

public class TemplateGenerateException extends FrameworkException
{

    public TemplateGenerateException()
    {
        super("\uD15C\uD50C\uB9BF\uC73C\uB85C \uACB0\uACFC \uC0DD\uC131 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.");
    }

    public TemplateGenerateException(String message)
    {
        super(message);
    }

    public TemplateGenerateException(Throwable t)
    {
        super("\uD15C\uD50C\uB9BF\uC73C\uB85C \uACB0\uACFC \uC0DD\uC131 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", t);
    }

    public TemplateGenerateException(String message, Throwable t)
    {
        super(message, t);
    }

    private static final long serialVersionUID = 0xd859f56d8d9138f7L;
    private static final String DEFAULT_ERROR_MESSAGE = "\uD15C\uD50C\uB9BF\uC73C\uB85C \uACB0\uACFC \uC0DD\uC131 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.";
}
