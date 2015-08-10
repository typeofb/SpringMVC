// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MultipartFileUtils.java

package hanwha.hone.runtime.util;

import hanwha.hone.runtime.infra.exception.FrameworkException;
import java.io.File;
import java.io.OutputStream;
import java.util.Date;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

// Referenced classes of package hanwha.hone.runtime.util:
//            CalendarUtils, StringUtils

public class MultipartFileUtils
{

    public MultipartFileUtils()
    {
    }

    /**
     * @deprecated Method copyMultipartFile is deprecated
     */

    public static MultipartFile copyMultipartFile(MultipartFile multipartFile, String targetPath, String pathType)
        throws Exception
    {
        File outFile = copyFile(multipartFile, targetPath, pathType);
        DiskFileItem fileItem = new DiskFileItem(multipartFile.getName(), multipartFile.getContentType(), true, multipartFile.getOriginalFilename(), 4096, outFile);
        OutputStream buffer = fileItem.getOutputStream();
        buffer.close();
        MultipartFile output = new CommonsMultipartFile(fileItem);
        return output;
    }

    /**
     * @deprecated Method copyFiles is deprecated
     */

    public static MultipartFile[] copyFiles(MultipartFile multipartFiles[], String targetPath, String pathType)
        throws Exception
    {
        MultipartFile outputs[] = new MultipartFile[multipartFiles.length];
        for(int index = 0; index < multipartFiles.length; index++)
            outputs[index] = copyMultipartFile(multipartFiles[index], targetPath, pathType);

        return outputs;
    }

    public static File copyFile(MultipartFile multipartFile, String targetPath, String pathType)
        throws Exception
    {
        Assert.notNull(multipartFile, "\uBCF5\uC0AC\uD560  MultipartFile \uAC1D\uCCB4\uB294 null\uC774 \uB420 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.");
        Assert.hasLength(targetPath, "\uBCF5\uC0AC\uD560 \uC704\uCE58\uC778 targetPath\uB294 null\uC774 \uB420 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.");
        File outputPath = null;
        String targetDir = targetPath;
        if(File.separator.equals(targetDir.substring(targetDir.length() - 1)))
            targetDir = targetDir.substring(0, targetDir.length() - 1);
        String datePath = null;
        if("".equals(pathType))
            outputPath = new File(targetDir);
        else
        if("yyyy/MM/dd".equals(pathType))
        {
            datePath = CalendarUtils.getFormattedDate("yyyy/MM/dd", new Date());
            outputPath = new File(targetDir + File.separator + datePath);
        } else
        if("yyyy/MM".equals(pathType))
        {
            datePath = CalendarUtils.getFormattedDate("yyyy/MM", new Date());
            outputPath = new File(targetDir + File.separator + datePath);
        } else
        {
            outputPath = new File(rightTrimFileSeparator(targetDir + File.separator + pathType));
        }
        if(!outputPath.exists())
            outputPath.mkdirs();
        String targetName = multipartFile.getOriginalFilename();
        if(!StringUtils.hasLength(targetName))
            targetName = multipartFile.getName();
        int pos = targetName.lastIndexOf(".");
        String fileName = targetName.substring(0, pos);
        String fileExt = targetName.substring(pos + 1);
        File outputFile = new File(outputPath, targetName);
        for(int fileIndex = 0; outputFile.exists(); fileIndex++)
        {
            if(fileIndex > 999)
                throw new FrameworkException(outputFile.getAbsolutePath() + "\uAC19\uC740 \uC774\uB984\uC758 \uD30C\uC77C\uC774 \uCD5C\uB300 \uAC2F\uC218\uC5D0 \uB3C4\uB2EC\uD588\uC2B5\uB2C8\uB2E4.");
            outputFile = new File(outputPath, fileName + "(" + fileIndex + ")." + fileExt);
        }

        multipartFile.transferTo(outputFile);
        return outputFile;
    }

    public static String clearPath(String basePath, String filePath)
    {
        String clearPath = StringUtils.defaultString(filePath);
        basePath = StringUtils.defaultString(basePath);
        clearPath = StringUtils.replace(clearPath, "\\", "/");
        if(clearPath.indexOf(basePath) > -1)
            clearPath = clearPath.substring(clearPath.indexOf(basePath) + basePath.length());
        return clearPath;
    }

    private static String rightTrimFileSeparator(String path)
    {
        String trimPath = path;
        if(StringUtils.hasText(trimPath))
        {
            trimPath = trimPath.trim();
            String lastChar = trimPath.substring(trimPath.length() - 1);
            if("\\".equals(lastChar))
                lastChar = trimPath.substring(trimPath.length() - 1);
            if("/".equals(lastChar))
                trimPath.substring(0, trimPath.length() - 1);
        }
        return trimPath;
    }

    public static final String PATH_TYPE_NONE = "";
    public static final String PATH_TYPE_DATE_Y_M_D = "yyyy/MM/dd";
    public static final String PATH_TYPE_DATE_Y_M = "yyyy/MM";
    public static final int MAX_FILE_INDEX = 999;
}
