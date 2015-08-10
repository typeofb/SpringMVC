// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SpringSchemaParserUtils.java

package kr.co.androider.spring3.util;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public abstract class SpringSchemaParserUtils
{

    public SpringSchemaParserUtils()
    {
    }

    public static String checkRequiredAndGetProperty(Element element, String elementName, String attributeName)
    {
        Assert.notNull(element, "Element \uAC1D\uCCB4\uB294 null\uC774 \uB420 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.");
        String attributeValue = element.getAttribute(attributeName);
        return checkRequiredAndRaiseException(attributeValue, elementName, attributeName);
    }

    public static String checkReleatedAttributeAndGetProperty(Element element, String elementName, String attributeName, String releatedAttributeName, String releatedAttributeValue, String checkCondition)
    {
        String attributeValue = element.getAttribute(attributeName);
        return checkReleatedAttributeAndRaiseException(attributeValue, elementName, attributeName, releatedAttributeName, releatedAttributeValue, checkCondition);
    }

    public static String checkRequiredAndRaiseException(String attribute, String elementName, String attributeName)
    {
        if(!StringUtils.hasText(attribute))
            throw new BeanDefinitionValidationException("<hone:" + elementName + "> '" + attributeName + "' \uAC12\uC740 \uD544\uC218 \uC785\uB2C8\uB2E4.");
        else
            return attribute;
    }

    public static String checkReleatedAttributeAndRaiseException(String attribute, String elementName, String attributeName, String releatedAttributeName, String releatedAttributeValue, String checkCondition)
    {
        if(releatedAttributeValue != null && releatedAttributeValue.equalsIgnoreCase(checkCondition) && !StringUtils.hasText(attribute))
            throw new BeanDefinitionValidationException("<hone:" + elementName + "> \uC758 '" + releatedAttributeName + "' \uAC12\uC774 '" + checkCondition + "' \uC77C \uACBD\uC6B0, '" + attributeName + "' \uAC12\uC740 \uD544\uC218 \uC785\uB2C8\uB2E4.");
        else
            return attribute;
    }
}
