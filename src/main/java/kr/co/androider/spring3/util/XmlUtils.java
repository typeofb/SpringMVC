// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XmlUtils.java

package kr.co.androider.spring3.util;

import java.io.IOException;
import java.io.StringReader;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XmlUtils
{

    public XmlUtils()
    {
    }

    public static Document getDocument(String xml)
    {
        StringReader reader = new StringReader(xml);
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        try
        {
            doc = builder.build(reader);
        }
        catch(JDOMException je)
        {
            throw new IllegalArgumentException(je.getLocalizedMessage());
        }
        catch(IOException ioe)
        {
            throw new IllegalArgumentException(ioe.getLocalizedMessage());
        }
        return doc;
    }

    public static String printFormat(String xml, Format format)
    {
        return printFormat(getDocument(xml), format);
    }

    public static String printFormat(Document doc, Format format)
    {
        XMLOutputter outputter = new XMLOutputter(format);
        return outputter.outputString(doc);
    }

    public static String printFormat(Element element, Format format)
    {
        XMLOutputter outputter = new XMLOutputter(format);
        return outputter.outputString(element);
    }

    public static String printPrettyFormat(String xml)
    {
        return printPrettyFormat(xml, "UTF-8");
    }

    public static String printPrettyFormat(String xml, String encoding)
    {
        Format format = Format.getPrettyFormat();
        format.setEncoding(encoding);
        return printFormat(xml, format);
    }

    public static String printPrettyFormat(Element element)
    {
        return printPrettyFormat(element, "UTF-8");
    }

    public static String printPrettyFormat(Element element, String encoding)
    {
        Format format = Format.getPrettyFormat();
        format.setEncoding(encoding);
        return printFormat(element, format);
    }

    public static String printPrettyFormat(Document document)
    {
        return printPrettyFormat(document, "UTF-8");
    }

    public static String printPrettyFormat(Document document, String encoding)
    {
        Format format = Format.getPrettyFormat();
        format.setEncoding(encoding);
        return printFormat(document, format);
    }

    public static String printRawFormat(String xml)
    {
        return printRawFormat(xml, "UTF-8");
    }

    public static String printRawFormat(String xml, String encoding)
    {
        Format format = Format.getRawFormat();
        format.setEncoding(encoding);
        return printFormat(xml, format);
    }

    public static String printRawFormat(Element element)
    {
        return printRawFormat(element, "UTF-8");
    }

    public static String printRawFormat(Element element, String encoding)
    {
        Format format = Format.getRawFormat();
        format.setEncoding(encoding);
        return printFormat(element, format);
    }

    public static String printRawFormat(Document document)
    {
        return printRawFormat(document, "UTF-8");
    }

    public static String printRawFormat(Document document, String encoding)
    {
        Format format = Format.getRawFormat();
        format.setEncoding(encoding);
        return printFormat(document, format);
    }

    public static String printCompactFormat(String xml)
    {
        return printCompactFormat(xml, "UTF-8");
    }

    public static String printCompactFormat(String xml, String encoding)
    {
        Format format = Format.getCompactFormat();
        format.setEncoding(encoding);
        return printFormat(getDocument(xml), format);
    }

    public static String printCompactFormat(Element element)
    {
        return printCompactFormat(element, "UTF-8");
    }

    public static String printCompactFormat(Element element, String encoding)
    {
        Format format = Format.getCompactFormat();
        format.setEncoding(encoding);
        return printFormat(element, format);
    }

    public static String printCompactFormat(Document document)
    {
        return printCompactFormat(document, "UTF-8");
    }

    public static String printCompactFormat(Document document, String encoding)
    {
        Format format = Format.getCompactFormat();
        format.setEncoding(encoding);
        return printFormat(document, format);
    }

    private static final String DEFAULT_ENCODING = "UTF-8";
}
