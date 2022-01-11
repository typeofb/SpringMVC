// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ArrayUtils.java

package kr.co.androider.spring3.util;


public class ArrayUtils
{

    public ArrayUtils()
    {
    }

    public static boolean contains(Object array[], Object valueToFind)
    {
        return org.apache.commons.lang.ArrayUtils.contains(array, valueToFind);
    }

    public static boolean equals(Object expected[], Object actual[])
    {
        return org.apache.commons.lang.ArrayUtils.isEquals(((Object) (expected)), ((Object) (actual)));
    }

    public static String[] join(String x[], String y[])
    {
        String result[] = new String[x.length + y.length];
        for(int i = 0; i < x.length; i++)
            result[i] = x[i];

        for(int i = 0; i < y.length; i++)
            result[i + x.length] = y[i];

        return result;
    }

    public static String[] join(String x[], String y[], boolean use[])
    {
        String result[] = new String[x.length + countTrue(use)];
        for(int i = 0; i < x.length; i++)
            result[i] = x[i];

        int k = x.length;
        for(int i = 0; i < y.length; i++)
            if(use[i])
                result[k++] = y[i];

        return result;
    }

    public static int[] join(int x[], int y[])
    {
        int result[] = new int[x.length + y.length];
        for(int i = 0; i < x.length; i++)
            result[i] = x[i];

        for(int i = 0; i < y.length; i++)
            result[i + x.length] = y[i];

        return result;
    }

    public static String toString(Object array[])
    {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < array.length; i++)
        {
            sb.append(array[i]);
            if(i < array.length - 1)
                sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }

    public static boolean isAllTrue(boolean array[])
    {
        for(int i = 0; i < array.length; i++)
            if(!array[i])
                return false;

        return true;
    }

    public static int countTrue(boolean array[])
    {
        int result = 0;
        for(int i = 0; i < array.length; i++)
            if(array[i])
                result++;

        return result;
    }

    public static boolean isAllFalse(boolean array[])
    {
        for(int i = 0; i < array.length; i++)
            if(array[i])
                return false;

        return true;
    }

    public static boolean hasLength(Object arr[])
    {
        return arr != null && arr.length > 0;
    }

    public static boolean equals(int expected, int target[])
    {
        if(target == null || target.length < 1)
            return true;
        int size = target.length;
        for(int i = 0; i < size; i++)
            if(target[i] != expected)
                return false;

        return true;
    }

    public static final String EMPTY_STRING_ARRAY[] = new String[0];
    public static final int EMPTY_INT_ARRAY[] = new int[0];
    public static final boolean EMPTY_BOOLEAN_ARRAY[] = new boolean[0];
    public static final Class EMPTY_CLASS_ARRAY[] = new Class[0];
    public static final Object EMPTY_OBJECT_ARRAY[] = new Object[0];

}
