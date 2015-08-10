// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExcelParser.java

package hanwha.hone.runtime.util.excel;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface ExcelParser
{

    public abstract void addRowMapper(int i, String s);

    public abstract void addRowMapper(int i, String s, String s1);

    public abstract List parse(File file, Class class1)
        throws Exception;

    public abstract List parse(InputStream inputstream, Class class1)
        throws Exception;

    public static final int DEFAULT_START_ROW = 0;
    public static final int DEFAULT_SHEET_NO = 0;
}
