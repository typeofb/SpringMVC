// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringUtils.java

package hanwha.hone.runtime.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package hanwha.hone.runtime.util:
//            FormattingUtils

public class StringUtils extends org.springframework.util.StringUtils
{

    public StringUtils()
    {
    }

    public static boolean matches(String s, String pattern)
    {
        if(!hasText(s) || !hasText(pattern))
            return false;
        else
            return Pattern.compile(pattern).matcher(s).matches();
    }

    public static boolean contains(String s, String pattern)
    {
        if(!hasText(s) || !hasText(pattern))
            return false;
        else
            return Pattern.compile(pattern).matcher(s).find();
    }

    public static boolean containsCaseInsensitive(String s, String pattern)
    {
        if(!hasText(s) || !hasText(pattern))
            return false;
        else
            return Pattern.compile(pattern, 2).matcher(s).find();
    }

    public static boolean containsNumber(String s)
    {
        return contains(s, "[0-9]");
    }

    public static boolean containsAlphabet(String s)
    {
        return contains(s, "[a-zA-Z]");
    }

    public static boolean containsUpperCase(String s)
    {
        return contains(s, "[A-Z]");
    }

    public static boolean containsLowerCase(String s)
    {
        return contains(s, "[a-z]");
    }

    public static boolean containsKorean(String s)
    {
        return contains(s, "[\u3131-\u314E\u314F-\u3163\uAC00-\uD7A3]");
    }

    public static boolean isAlphabet(String s)
    {
        return matches(s, "[a-zA-Z]*");
    }

    public static boolean isUpperCase(String s)
    {
        return matches(s, "[A-Z]*");
    }

    public static boolean isLowerCase(String s)
    {
        return matches(s, "[a-z]*");
    }

    public static boolean isKorean(String s)
    {
        return matches(s, "[\u3131-\u314E\u314F-\u3163\uAC00-\uD7A3]*");
    }

    public static boolean isAlphaNumeric(String s)
    {
        return matches(s, "[\\s\\w]*");
    }

    public static boolean isMixedAlphaNumeric(String s)
    {
        return containsNumber(s) && containsAlphabet(s);
    }

    public static boolean isNull(String s)
    {
        return s == null;
    }

    public static boolean isNullString(String s)
    {
        return hasText(s) && s.trim().equals("null");
    }

    public static String[] splitByRegExp(String src, String delimExp)
    {
        if(!hasText(src))
            return null;
        if(!hasText(delimExp))
            return (new String[] {
                src
            });
        else
            return src.split(delimExp);
    }

    public static int repetitionCount(String target, String pattern)
    {
        int count;
        try
        {
            if(!isContained(target, pattern))
                return 0;
        }
        catch(Exception e)
        {
            return -1;
        }
        count = 0;
        for(String dest = target; dest.indexOf(pattern) >= 0;)
        {
            dest = dest.replaceFirst(pattern, "");
            count++;
        }

        return count;
    }

    public static boolean isContained(String target, String pattern)
    {
        return contains(target, pattern);
    }

    public static String trimSpecifiedString(String target, String pattern[])
    {
        String result = null;
        if(target == null)
            return null;
        if(pattern == null)
            return target;
        for(int i = 0; i < pattern.length; i++)
            if(target.endsWith(pattern[i]))
                result = target.replaceAll(pattern[i], "");

        result = result.trim();
        return result;
    }

    public static boolean isForwardContinousLetter(String target, int permissableCount)
    {
        return isContinousLetter(target, permissableCount, true);
    }

    public static boolean isBackwardContinousLetter(String target, int permissableCount)
    {
        return isContinousLetter(target, permissableCount, false);
    }

    public static boolean isContinousLetter(String target, int permissableCount, boolean isForward)
    {
        if(!hasText(target))
            return false;
        char tempChar = '\0';
        int tempCount = 0;
        permissableCount--;
        int i = 0;
        for(int targetLength = target.length(); i < targetLength; i++)
        {
            char currentChar = target.charAt(i);
            if(isForward)
            {
                if(i != 0 && currentChar == tempChar + 1)
                    tempCount++;
                else
                    tempCount = 0;
            } else
            if(i != 0 && currentChar == tempChar - 1)
                tempCount++;
            else
                tempCount = 0;
            if(tempCount == permissableCount)
                return true;
            tempChar = currentChar;
        }

        return false;
    }

    public static final String defaultString(String s)
    {
        return defaultString(s, "");
    }

    public static final String defaultString(String s, String defaultString)
    {
        if(s == null)
            return defaultString;
        else
            return s;
    }

    public static String printFormattedToHexString(String target)
    {
        return printFormattedToHexString(target.getBytes());
    }

    public static String printFormattedToHexString(byte target[])
    {
        StringBuffer buffer = new StringBuffer("[");
        for(int i = 0; i < target.length; i++)
        {
            buffer.append(toHexString(target[i]));
            if(i != target.length - 1)
                buffer.append(",");
        }

        buffer.append("]");
        return buffer.toString();
    }

    public static String printHexString(String target, int lineShowCharSize)
    {
        return printHexString(target.getBytes(), lineShowCharSize);
    }

    public static String printHexString(byte target[], int lineShowCharSize)
    {
        byte cloneTarget[] = new byte[target.length];
        for(int i = 0; i < cloneTarget.length; i++)
            cloneTarget[i] = target[i] < 0 || target[i] >= 32 ? target[i] : 46;

        StringBuffer buffer = new StringBuffer(prettyPrint(lineShowCharSize));
        buffer.append("Source bytes Length : [").append(target.length).append("]\n");
        buffer.append(prettyPrint(lineShowCharSize));
        buffer.append("[   Row Number]");
        for(int i = 1; i <= lineShowCharSize; i++)
            buffer.append(" ").append(leftPadding(Integer.toString(i), 2, '0'));

        buffer.append(" | [").append(leftPadding("DATA]", lineShowCharSize - 1, ' '));
        buffer.append("\n");
        buffer.append(prettyPrint(lineShowCharSize));
        int printCount = target.length % lineShowCharSize;
        printCount = printCount != 0 ? target.length / lineShowCharSize + 1 : target.length / lineShowCharSize;
        for(int i = 0; i < printCount; i++)
        {
            buffer.append("[").append(leftPadding(Integer.toString(i * lineShowCharSize + 1), 6, '0')).append("-");
            if(i == printCount)
                buffer.append(leftPadding(Integer.toString(target.length), 6, '0'));
            else
                buffer.append(leftPadding(Integer.toString((i + 1) * lineShowCharSize), 6, '0'));
            buffer.append("]");
            for(int j = 0; j < lineShowCharSize && i * lineShowCharSize + j != target.length; j++)
                buffer.append(" ").append(toHexString(target[i * lineShowCharSize + j]));

            if(target.length % lineShowCharSize != 0 && i == printCount - 1)
            {
                int appendCount = (lineShowCharSize - target.length % lineShowCharSize) * 3;
                buffer.append(rightPadding("", appendCount, ' '));
                buffer.append(" | ");
                buffer.append(new String(cloneTarget, i * lineShowCharSize, target.length % lineShowCharSize));
            } else
            {
                buffer.append(" | ");
                buffer.append(new String(cloneTarget, i * lineShowCharSize, lineShowCharSize));
            }
            buffer.append("\n");
        }

        buffer.append(prettyPrint(lineShowCharSize));
        return buffer.toString();
    }

    private static String prettyPrint(int lineShowCharSize)
    {
        StringBuffer buffer = new StringBuffer("===============");
        for(int i = 1; i <= lineShowCharSize; i++)
            buffer.append("===");

        buffer.append("===");
        for(int i = 1; i <= lineShowCharSize; i++)
            buffer.append("=");

        buffer.append("\n");
        return buffer.toString();
    }

    public static String toHexString(byte target)
    {
        int i = target >= 0 ? ((int) (target)) : target & 0xff;
        String targetString = Integer.toHexString(i).toUpperCase();
        return leftPadding(targetString, 2, '0');
    }

    public static String toHexString(String target)
    {
        if(target == null)
            return null;
        else
            return toHexString(target.getBytes());
    }

    public static String toHexString(byte target[])
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < target.length; i++)
            buffer.append(Integer.toHexString(target[i]));

        return buffer.toString();
    }

    public static String makeTemplateString(int size, char initialChar)
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < size; i++)
            buffer.append(initialChar);

        return buffer.toString();
    }

    public static String leftPadding(String src, int size, char paddingChar)
    {
        return FormattingUtils.lPadding(src, size, paddingChar);
    }

    public static String rightPadding(String src, int size, char paddingChar)
    {
        return FormattingUtils.rPadding(src, size, paddingChar);
    }

    public static String normalizeWhiteSpace(String src)
    {
        if(src == null)
            return null;
        else
            return src.replaceAll("\\s", "");
    }

    public static String convertCamalCase(String src)
    {
        return convertCamalCase(src, "_");
    }

    public static String convertCamalCase(String src, String delimiter)
    {
        if(!hasText(src))
            return src;
        String words[] = tokenizeToStringArray(src, delimiter);
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < words.length; i++)
        {
            String word = words[i];
            buffer.append(capitalize(word));
        }

        return buffer.toString();
    }

    public static String toDoubleByteCharSetString(String halfString)
    {
        String fullString = "";
        if(hasText(halfString))
        {
            int len = halfString.length();
            for(int i = 0; i < len; i++)
            {
                char c = halfString.charAt(i);
                if(c == ' ')
                {
                    fullString = fullString + String.valueOf('\u3000');
                    continue;
                }
                if(c >= '\uAC00' && c <= '\uD7A3')
                    fullString = fullString + c;
                else
                    fullString = fullString + String.valueOf((char)(c + 65248));
            }

        }
        return fullString;
    }

    public static String toMixedCharSetString(String fullString)
    {
        String halfString = "";
        if(hasText(fullString))
        {
            int len = fullString.length();
            for(int i = 0; i < len; i++)
            {
                char c = fullString.charAt(i);
                if(c == '\u3000')
                {
                    halfString = halfString + " ";
                    continue;
                }
                if(c >= '\uAC00' && c <= '\uD7A3')
                {
                    halfString = halfString + c;
                    continue;
                }
                if(c >= '\uFF00' && c <= '\uFFEF')
                    halfString = halfString + String.valueOf((char)(c - 65248));
                else
                    halfString = halfString + c;
            }

        }
        return halfString;
    }

    public static String delete(String inString, String pattern)
    {
        if(!hasText(pattern))
            return inString;
        else
            return replace(inString, pattern, "");
    }

    public static String camelize(String s, String splitPattern)
    {
        if(!hasText(s))
            return s;
        String parts[] = s.split(splitPattern);
        if(parts.length == 1)
            return parts[0].toLowerCase();
        StringBuffer camelized = new StringBuffer();
        for(int i = 0; i < parts.length; i++)
            if(hasText(parts[i]))
            {
                camelized.append(Character.toUpperCase(parts[i].charAt(0)));
                camelized.append(parts[i].substring(1).toLowerCase());
            }

        camelized.setCharAt(0, Character.toLowerCase(camelized.charAt(0)));
        return camelized.toString();
    }

    public static String camelize(String s)
    {
        return camelize(s, "_");
    }

    public static String decamelize(String s, String splitPattern, boolean toUpperCase)
    {
        if(!hasText(s))
            return s;
        StringBuffer decamelized = new StringBuffer();
        if(toUpperCase)
            decamelized.append(Character.toUpperCase(s.charAt(0)));
        else
            decamelized.append(Character.toLowerCase(s.charAt(0)));
        int i = 1;
        for(int length = s.length(); i < length; i++)
        {
            char c = s.charAt(i);
            if(i != 0 && Character.isUpperCase(c))
                decamelized.append(splitPattern);
            if(toUpperCase)
                decamelized.append(Character.toUpperCase(c));
            else
                decamelized.append(Character.toLowerCase(c));
        }

        return decamelized.toString();
    }

    public static String decamelize(String s)
    {
        return decamelize(s, "_", true);
    }
}
