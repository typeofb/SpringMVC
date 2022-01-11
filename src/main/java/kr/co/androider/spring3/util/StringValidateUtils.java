// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringValidateUtils.java

package kr.co.androider.spring3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package kr.co.androider.spring3.util:
//            StringUtils, NumberUtils

public class StringValidateUtils
{

    public StringValidateUtils()
    {
    }

    public static boolean isValidSsn(String s)
    {
        if(!StringUtils.hasText(s) || s.length() != 13 || !NumberUtils.isNumber(s))
            return false;
        char identifier = s.charAt(6);
        StringBuffer birthDate = new StringBuffer();
        int sum = 0;
        int pieceOfSsns[];
        if(identifier == '5' || identifier == '6' || identifier == '7' || identifier == '8' || identifier == '9' || identifier == '0')
        {
            switch(identifier)
            {
            case 53: // '5'
            case 54: // '6'
                birthDate.append("19");
                break;

            case 55: // '7'
            case 56: // '8'
                birthDate.append("20");
                break;

            case 48: // '0'
            case 57: // '9'
                birthDate.append("18");
                break;

            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            default:
                return false;
            }
            birthDate.append(s.substring(0, 2));
            birthDate.append(s.substring(2, 4));
            birthDate.append(s.substring(4, 6));
            if(!isSsnDate(birthDate.toString()))
                return false;
            pieceOfSsns = divideSsn(s);
            int odd = pieceOfSsns[7] * 10 + pieceOfSsns[8];
            if(odd % 2 != 0)
                return false;
            if(pieceOfSsns[11] != 6 && pieceOfSsns[11] != 7 && pieceOfSsns[11] != 8 && pieceOfSsns[11] != 9)
                return false;
            int i = 0;
            for(int len = MULTIPLIERS.length; i < len; i++)
                sum += pieceOfSsns[i] * MULTIPLIERS[i];

            sum = 11 - sum % 11;
            sum = sum < 10 ? sum : sum - 10;
            sum = (sum += 2) < 10 ? sum : sum - 10;
            return sum == pieceOfSsns[12];
        }
        switch(identifier)
        {
        case 49: // '1'
        case 50: // '2'
            birthDate.append("19");
            break;

        case 51: // '3'
        case 52: // '4'
            birthDate.append("20");
            break;

        default:
            return false;
        }
        birthDate.append(s.substring(0, 2));
        birthDate.append(s.substring(2, 4));
        birthDate.append(s.substring(4, 6));
        if(!isSsnDate(birthDate.toString()))
            return false;
        pieceOfSsns = divideSsn(s);
        int i = 0;
        for(int len = MULTIPLIERS.length; i < len; i++)
            sum += pieceOfSsns[i] * MULTIPLIERS[i];

        sum = 11 - sum % 11;
        sum = sum < 10 ? sum : sum - 10;
        return sum == pieceOfSsns[12];
    }

    private static boolean isSsnDate(String s)
    {
        if(!StringUtils.hasText(s))
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        boolean result = false;
        if(s == null || formatter == null)
            return false;
        Date date = null;
        try
        {
            date = formatter.parse(s);
        }
        catch(ParseException e)
        {
            return false;
        }
        if(formatter.format(date).equals(s))
            result = true;
        return result;
    }

    private static int[] divideSsn(String s)
    {
        int returnData[] = new int[13];
        char tempChar[] = s.toCharArray();
        int i = 0;
        for(int len = tempChar.length; i < len; i++)
            returnData[i] = Integer.parseInt(String.valueOf(tempChar[i]));

        return returnData;
    }

    public static final String calcFullAge(Date today, String s)
    {
        if(!isValidSsn(s))
            throw new IllegalArgumentException("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638 [" + s + "] \uAC00 \uC798\uBABB\uB41C \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638 \uC785\uB2C8\uB2E4.");
        String birthDay = null;
        char identifier = s.charAt(6);
        switch(identifier)
        {
        case 49: // '1'
        case 50: // '2'
        case 53: // '5'
        case 54: // '6'
            birthDay = "19";
            break;

        case 51: // '3'
        case 52: // '4'
        case 55: // '7'
        case 56: // '8'
            birthDay = "20";
            break;

        case 48: // '0'
        case 57: // '9'
            birthDay = "18";
            break;
        }
        birthDay = birthDay + s.substring(0, 6);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        String birthDate = birthDay.substring(4);
        String currentDate = (new SimpleDateFormat("yyyy")).format(today);
        int birthYear = Integer.parseInt(birthDay.substring(0, 4));
        int todayYear = calendar.get(1);
        int age = todayYear - birthYear;
        if(currentDate.compareTo(birthDate) < 0)
            age--;
        return Integer.toString(age);
    }

    public static final String calcFullAge(String s)
    {
        return calcFullAge(new Date(), s);
    }

    public static String formatSsn(String ssn)
    {
        if(ssn.length() != 13)
            throw new IllegalArgumentException("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638 '" + ssn + "'\uB294 13\uC790\uB9AC\uC774\uC5B4\uC57C \uD569\uB2C8\uB2E4.");
        else
            return ssn.substring(0, 6) + "-" + ssn.substring(6, 13);
    }

    public static boolean isValidEmail(String s)
    {
        return StringUtils.matches(s, "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9\\-\\_]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
    }

    private static final int MULTIPLIERS[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 
        4, 5
    };

}
