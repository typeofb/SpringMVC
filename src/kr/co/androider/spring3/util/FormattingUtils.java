// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FormattingUtils.java

package kr.co.androider.spring3.util;


public abstract class FormattingUtils
{

    public FormattingUtils()
    {
    }

    public static String lPadding(String src, int size, char paddingChar)
    {
        int srcLength = 0;
        if(src == null)
        {
            StringBuffer result = new StringBuffer();
            for(int i = 0; i < size; i++)
                result.append(paddingChar);

            return result.toString();
        }
        byte srcBytes[] = src.getBytes();
        srcLength = srcBytes.length;
        if(size == srcLength)
            return src;
        if(size < srcLength)
            return new String(srcBytes, 0, size);
        int paddingCount = size - srcLength;
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < paddingCount; i++)
            result.append(paddingChar);

        result.append(src);
        return result.toString();
    }

    public static String rPadding(String src, int size, char paddingChar)
    {
        int srcLength = 0;
        if(src == null)
        {
            StringBuffer result = new StringBuffer();
            for(int i = 0; i < size; i++)
                result.append(paddingChar);

            return result.toString();
        }
        byte srcBytes[] = src.getBytes();
        srcLength = srcBytes.length;
        if(size == srcLength)
            return src;
        if(size < srcLength)
            return new String(srcBytes, 0, size);
        int paddingCount = size - srcLength;
        StringBuffer result = new StringBuffer(src);
        for(int i = 0; i < paddingCount; i++)
            result.append(paddingChar);

        return result.toString();
    }
}
