// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BeanDefinitionCreator.java

package hanwha.hone.runtime.util;

import org.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionCreator
{

    public abstract BeanDefinition createDefinition();
}
