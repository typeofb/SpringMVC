// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NetUtils.java

package kr.co.androider.spring3.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package kr.co.androider.spring3.util:
//            FormattingUtils

public abstract class NetUtils
{

    public NetUtils()
    {
    }

    private static void initInetAddress()
    {
        try
        {
            byte bip[] = InetAddress.getLocalHost().getAddress();
            for(int i = 0; i < bip.length; i++)
                localAddress[i] = bip[i] & 0xff;

        }
        catch(UnknownHostException e)
        {
            localAddress[0] = 127;
            localAddress[1] = 0;
            localAddress[2] = 0;
            localAddress[3] = 1;
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < localAddress.length; i++)
            buffer.append(FormattingUtils.lPadding(Integer.toHexString(localAddress[i]), 2, '0'));

        hexLocalAddress = buffer.toString();
    }

    public static String getHexLocalAddress()
    {
        if(hexLocalAddress == null)
            initInetAddress();
        return hexLocalAddress;
    }

    private static int localAddress[] = new int[4];
    private static String hexLocalAddress;

    static 
    {
        initInetAddress();
    }
}
