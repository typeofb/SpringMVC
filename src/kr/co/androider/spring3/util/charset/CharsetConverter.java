// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CharsetConverter.java

package hanwha.hone.runtime.util.charset;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.nio.charset.spi.CharsetProvider;
import sun.io.ByteToCharConverter;
import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.StandardCharsets;

// Referenced classes of package hanwha.hone.runtime.util.charset:
//            CharsetConvertException

public class CharsetConverter
{
    private static class CharsetSD extends StringDecoder
    {

        String charsetName()
        {
            if(cs instanceof HistoricallyNamedCharset)
                return ((HistoricallyNamedCharset)cs).historicalName();
            else
                return cs.name();
        }

        char[] decode(byte ba[], int off, int len)
        {
            int en = (int)(cd.maxCharsPerByte() * (float)len);
            char ca[] = new char[en];
            if(len == 0)
                return ca;
            cd.reset();
            ByteBuffer bb = ByteBuffer.wrap(ba, off, len);
            CharBuffer cb = CharBuffer.wrap(ca);
            try
            {
                CoderResult cr = cd.decode(bb, cb, true);
                if(!cr.isUnderflow())
                    cr.throwException();
                cr = cd.flush(cb);
                if(!cr.isUnderflow())
                    cr.throwException();
            }
            catch(CharacterCodingException x)
            {
                throw new Error(x);
            }
            return CharsetConverter.trim(ca, cb.position());
        }

        private final Charset cs;
        private final CharsetDecoder cd;

        private CharsetSD(Charset cs, String rcn)
        {
            super(rcn);
            this.cs = cs;
            cd = cs.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        }

    }

    private static class ConverterSD extends StringDecoder
    {

        String charsetName()
        {
            return btc.getCharacterEncoding();
        }

        char[] decode(byte ba[], int off, int len)
        {
            int en = btc.getMaxCharsPerByte() * len;
            char ca[] = new char[en];
            if(len == 0)
                return ca;
            btc.reset();
            int n = 0;
            try
            {
                n = btc.convert(ba, off, off + len, ca, 0, en);
                n += btc.flush(ca, btc.nextCharIndex(), en);
            }
            catch(CharConversionException x)
            {
                n = btc.nextCharIndex();
            }
            return CharsetConverter.trim(ca, n);
        }

        private ByteToCharConverter btc;

        private ConverterSD(ByteToCharConverter btc, String rcn)
        {
            super(rcn);
            this.btc = btc;
        }

    }

    private static abstract class StringDecoder
    {

        final String getRequestedCharsetName()
        {
            return requestedCharsetName;
        }

        abstract String charsetName();

        abstract char[] decode(byte abyte0[], int i, int j);

        private final String requestedCharsetName;

        protected StringDecoder(String requestedCharsetName)
        {
            this.requestedCharsetName = requestedCharsetName;
        }
    }


    public CharsetConverter()
    {
    }

    public static byte[] asciiToEbcdicOneByte(String inStr)
        throws CharsetConvertException
    {
        if(inStr == null)
            return null;
        try
        {
            String asciiStr = new String(inStr.getBytes(), "8859_1");
            return asciiStr.getBytes("cp500");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("ASCII(8859_1:1byte)", "EBCDIC(cp500:1byte)", e);
        }
    }

    public static String ebcdicToAsciiOneByte(byte ebcdicBytes[])
        throws CharsetConvertException
    {
        if(ebcdicBytes == null)
            return null;
        try
        {
            return new String(ebcdicBytes, "cp500");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("EBCDIC(cp500:1byte)", "ASCII(8859_1:1byte)", e);
        }
    }

    public static byte[] asciiToEbcdicTwoByte(String inStr)
        throws CharsetConvertException
    {
        if(inStr == null)
            return null;
        try
        {
            String asciiStr = new String(inStr.getBytes(), "ksc5601");
            return asciiStr.getBytes("cp933");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("ASCII(ksc5601:2bytes)", "EBCDIC(cp933:2bytes)", e);
        }
    }

    public static byte[] asciiToEbcdicTwoByteForIMS(String inStr)
        throws CharsetConvertException
    {
        if(inStr == null)
            return null;
        try
        {
            String asciiStr = new String(inStr.getBytes(), "ksc5601");
            byte ebcdic[] = asciiStr.getBytes("cp933");
            ByteArrayOutputStream ims = new ByteArrayOutputStream();
            for(int i = 0; i < ebcdic.length; i++)
                if(ebcdic[i] != 14 && ebcdic[i] != 15)
                    ims.write(ebcdic[i]);

            return ims.toByteArray();
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("ASCII(ksc5601:2bytes)", "EBCDIC(cp933:2bytes)", e);
        }
    }

    public static String ebcdicToAsciiTwoByte(byte ebcdicBytes[])
        throws CharsetConvertException
    {
        if(ebcdicBytes == null)
            return null;
        try
        {
            return new String(ebcdicBytes, "cp933");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("EBCDIC(cp933:2bytes)", "ASCII(ksc5601:2bytes)", e);
        }
    }

    public static byte[] toEbcdicTwoByte(String inStr)
        throws CharsetConvertException
    {
        if(inStr == null)
            return null;
        try
        {
            return inStr.getBytes("cp933");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("\uBB38\uC790\uC5F4\uC744 EBCDIC(cp933) byte[]\uB85C \uBCC0\uD658\uD558\uB294 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", e);
        }
    }

    public static String toAsciiTwoByte(String inStr)
        throws CharsetConvertException
    {
        if(inStr == null)
            return null;
        try
        {
            return new String(inStr.getBytes("ksc5601"));
        }
        catch(UnsupportedEncodingException e)
        {
            throw new CharsetConvertException("\uBB38\uC790\uC5F4\uC744 ASCII(ksc5601) byte[]\uB85C \uBCC0\uD658\uD558\uB294 \uC911 \uC624\uB958\uAC00 \uBC1C\uC0DD\uD558\uC600\uC2B5\uB2C8\uB2E4.", e);
        }
    }

    public static String toDoubleByteCharSetString(String mixedCharSetString)
    {
        if(mixedCharSetString == null)
            return null;
        char mixedCharSet[] = mixedCharSetString.toCharArray();
        for(int i = 0; i < mixedCharSet.length; i++)
        {
            int codeValue = mixedCharSet[i];
            if(codeValue >= 255)
                continue;
            if(codeValue == 32)
                codeValue = 12288;
            else
                codeValue = (codeValue + 65280) - 32;
            mixedCharSet[i] = (char)codeValue;
        }

        return new String(mixedCharSet);
    }

    public static String toMixedCharSetString(String doubleByteCharSetString)
    {
        if(doubleByteCharSetString == null)
            return null;
        char doubleByteCharSet[] = doubleByteCharSetString.toCharArray();
        for(int i = 0; i < doubleByteCharSet.length; i++)
        {
            int codeValue = doubleByteCharSet[i];
            if(codeValue == 12288)
            {
                codeValue = 32;
                doubleByteCharSet[i] = (char)codeValue;
            }
            if(codeValue >= 65280)
            {
                codeValue = (codeValue - 65280) + 32;
                doubleByteCharSet[i] = (char)codeValue;
            }
        }

        return new String(doubleByteCharSet);
    }

    public static String ebcdicToAsciiTwoByteFast(byte ebcdicBytes[])
        throws CharsetConvertException
    {
        StringDecoder sd = null;
        Charset cs = standardProvider.charsetForName("cp933");
        if(cs != null)
            sd = new CharsetSD(cs, "cp933");
        else
            try
            {
                sd = new ConverterSD(ByteToCharConverter.getConverter("cp933"), "cp933");
            }
            catch(UnsupportedEncodingException e)
            {
                throw new CharsetConvertException("EBCDIC(cp933:2bytes)", "ASCII(ksc5601:2bytes)", e);
            }
        char arr[] = sd.decode(ebcdicBytes, 0, ebcdicBytes.length);
        return new String(arr);
    }

    public static byte[] trim(byte ba[], int len)
    {
        if(len == ba.length)
        {
            return ba;
        } else
        {
            byte tba[] = new byte[len];
            System.arraycopy(ba, 0, tba, 0, len);
            return tba;
        }
    }

    private static char[] trim(char ca[], int len)
    {
        if(len == ca.length)
        {
            return ca;
        } else
        {
            char tca[] = new char[len];
            System.arraycopy(ca, 0, tca, 0, len);
            return tca;
        }
    }

    public static final String ONE_BYTE_ASCII_CODE = "8859_1";
    public static final String ONE_BYTE_EBCDIC_CODE = "cp500";
    public static final String TWO_BYTE_ASCII_CODE = "ksc5601";
    public static final String TWO_BYTE_EBCDIC_CODE = "cp933";
    private static CharsetProvider standardProvider = new StandardCharsets();


}
