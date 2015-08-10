// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileItemUtils.java

package hanwha.hone.runtime.util;

import hanwha.hone.runtime.web.filedownload.FileItem;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package hanwha.hone.runtime.util:
//            StringUtils

public class FileItemUtils
{

    public FileItemUtils()
    {
    }

    public static void renameTo(FileItem item, String newName, boolean hasMeta)
    {
        if(item == null)
        {
            logger.warn("\uC694\uCCAD FileItem\uC774 Null\uC774\uBBC0\uB85C \uD30C\uC77C\uBA85 \uBCC0\uD658\uC744 \uC218\uD589\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
            return;
        }
        if(item.getFile() == null)
        {
            logger.warn("\uC694\uCCAD FileItem\uC758 File\uC774 Null\uC774\uBBC0\uB85C \uD30C\uC77C\uBA85 \uBCC0\uD658\uC744 \uC218\uD589\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
            return;
        }
        File originalFile = item.getFile();
        String newFilePath = resolveFilePath(originalFile);
        File newFile = new File(newFilePath + newName);
        try
        {
            originalFile.renameTo(newFile);
            StringUtils.replace(item.getJsonString(), item.getStoreFilename(), newName);
            item.setFile(newFile);
            item.setStoreFilename(newName);
            originalFile.delete();
            if(hasMeta)
            {
                File originalMetaFile = new File(originalFile.getAbsoluteFile() + "_meta");
                if(originalMetaFile != null && originalMetaFile.isFile())
                {
                    File newMetaFile = new File(newFilePath + newName + "_meta");
                    originalMetaFile.renameTo(newMetaFile);
                    originalMetaFile.delete();
                }
            }
        }
        catch(Exception e)
        {
            logger.error("\uD30C\uC77C \uCC98\uB9AC \uC911 \uC608\uC0C1\uCE58 \uBABB\uD55C \uC608\uC678\uAC00 \uBC1C\uC0DD\uD558\uC5EC, \uD30C\uC77C \uC774\uB3D9(\uB610\uB294 \uBCF5\uC0AC)\uB97C \uD558\uC9C0 \uBABB\uD558\uC600\uC2B5\uB2C8\uB2E4.", e);
        }
    }

    private static String resolveFilePath(File originalFile)
    {
        return StringUtils.replace(originalFile.getAbsolutePath(), originalFile.getName(), "");
    }

    static Class _mthclass$(String x0)
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
        logger = LoggerFactory.getLogger(hanwha.hone.runtime.util.FileItemUtils.class);
    }
}
