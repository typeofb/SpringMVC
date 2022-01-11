// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SimpleJExcelParser.java

package kr.co.androider.spring3.util.excel;

import kr.co.androider.spring3.util.CalendarUtils;
import kr.co.androider.spring3.util.StringUtils;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import jxl.*;
import org.springframework.beans.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.ClassUtils;

// Referenced classes of package kr.co.androider.spring3.util.excel:
//            ExcelParser

public class SimpleJExcelParser
    implements ExcelParser
{

    public SimpleJExcelParser(int sheetNo, int startRow)
    {
        this.startRow = 0;
        this.sheetNo = 0;
        objectMapper = new HashMap();
        objectFormatMapper = new HashMap();
        this.sheetNo = sheetNo;
        this.startRow = startRow;
    }

    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

    public int getStartRow()
    {
        return startRow;
    }

    public void setSheetNo(int sheetNo)
    {
        this.sheetNo = sheetNo;
    }

    public int getSheetNo()
    {
        return sheetNo;
    }

    public void addRowMapper(int col, String propertyName)
    {
        objectMapper.put(new Integer(col), propertyName);
    }

    public void addRowMapper(int col, String propertyName, String contentFormat)
    {
        addRowMapper(col, propertyName);
        objectFormatMapper.put(new Integer(col), contentFormat);
    }

    public List parse(File excelFile, Class objectClass)
        throws Exception
    {
        Workbook workbook = Workbook.getWorkbook(excelFile);
        List list = parse(workbook, objectClass);
        workbook.close();
        return list;
    }

    public List parse(InputStream input, Class objectClass)
        throws Exception
    {
        Workbook workbook = Workbook.getWorkbook(input);
        List list = parse(workbook, objectClass);
        workbook.close();
        return list;
    }

    protected List parse(Workbook workbook, Class objectClass)
        throws Exception
    {
        Sheet sheet = workbook.getSheet(sheetNo);
        int lastRow = sheet.getRows();
        List objectList = new ArrayList();
        int row = startRow;
        do
        {
            if(row >= lastRow)
                break;
            Object resultObject = getResultObject(sheet, row, objectClass);
            if(resultObject == null)
                break;
            objectList.add(resultObject);
            row++;
        } while(true);
        return objectList;
    }

    protected Object getResultObject(Sheet sheet, int row, Class objectClass)
        throws Exception
    {
        Object result = BeanUtils.instantiateClass(objectClass);
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(result);
        beanWrapper.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        Iterator cols = objectMapper.entrySet().iterator();
        do
        {
            if(!cols.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)cols.next();
            Integer col = (Integer)entry.getKey();
            String propertyName = (String)entry.getValue();
            String content = null;
            CellType cellType = sheet.getCell(col.intValue(), row).getType();
            Class propertyClass = beanWrapper.getPropertyType(propertyName);
            String cellFormat = (String)objectFormatMapper.get(col);
            if(propertyClass.isAssignableFrom(java.util.Date.class))
            {
                String dateFormat[] = {
                    "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss"
                };
                if(StringUtils.hasText(cellFormat))
                    dateFormat = (new String[] {
                        cellFormat
                    });
                java.util.Date date = null;
                if(CellType.DATE.equals(cellType))
                {
                    date = ((DateCell)sheet.getCell(col.intValue(), row)).getDate();
                } else
                {
                    content = sheet.getCell(col.intValue(), row).getContents();
                    date = CalendarUtils.parseDate(content, dateFormat);
                }
                content = CalendarUtils.getFormattedDate("yyyy-MM-dd HH:mm:ss", date);
            } else
            if(ClassUtils.isPrimitiveOrWrapper(propertyClass))
            {
                content = sheet.getCell(col.intValue(), row).getContents();
                if(content.indexOf(",") >= 0)
                    content = content.replaceAll("\\,", "");
            } else
            {
                content = sheet.getCell(col.intValue(), row).getContents();
            }
            if(StringUtils.hasText(content))
                beanWrapper.setPropertyValue(propertyName, content);
        } while(true);
        return result;
    }

    private static final String DEFAULT_CELL_TYPE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private int startRow;
    private int sheetNo;
    private Map objectMapper;
    private Map objectFormatMapper;
}
