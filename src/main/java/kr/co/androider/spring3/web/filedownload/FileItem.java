// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileItem.java

package kr.co.androider.spring3.web.filedownload;

import java.io.File;
import java.io.InputStream;

public interface FileItem
{

    public abstract String getName();

    public abstract String getOriginalFilename();

    public abstract String getStoreFilename();

    public abstract String getContentType();

    public abstract long getSize();

    public abstract InputStream getInputStream();

    public abstract File getFile();

    public abstract String getBasePath();

    public abstract String getRelativePath();

    public abstract String getAbsolutePath();

    public abstract String getJsonString();

    public abstract void setFile(File file);

    public abstract void setStoreFilename(String s);
}
