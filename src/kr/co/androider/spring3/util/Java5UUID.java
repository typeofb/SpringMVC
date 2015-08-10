// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Java5UUID.java

package hanwha.hone.runtime.util;

import java.io.*;
import java.security.*;

public class Java5UUID
    implements Serializable
{

    private Java5UUID(byte data[])
    {
        version = -1;
        variant = -1;
        timestamp = -1L;
        sequence = -1;
        node = -1L;
        hashCode = -1;
        long msb = 0L;
        long lsb = 0L;
        for(int i = 0; i < 8; i++)
            msb = msb << 8 | (long)(data[i] & 0xff);

        for(int i = 8; i < 16; i++)
            lsb = lsb << 8 | (long)(data[i] & 0xff);

        mostSigBits = msb;
        leastSigBits = lsb;
    }

    public Java5UUID(long mostSigBits, long leastSigBits)
    {
        version = -1;
        variant = -1;
        timestamp = -1L;
        sequence = -1;
        node = -1L;
        hashCode = -1;
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    public static Java5UUID randomUUID()
    {
        SecureRandom ng = numberGenerator;
        if(ng == null)
            numberGenerator = ng = new SecureRandom();
        byte randomBytes[] = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0xf;
        randomBytes[6] |= 0x40;
        randomBytes[8] &= 0x3f;
        randomBytes[8] |= 0x80;
        return new Java5UUID(randomBytes);
    }

    public static Java5UUID nameUUIDFromBytes(byte name[])
    {
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException nsae)
        {
            throw new InternalError("MD5 not supported");
        }
        byte md5Bytes[] = md.digest(name);
        md5Bytes[6] &= 0xf;
        md5Bytes[6] |= 0x30;
        md5Bytes[8] &= 0x3f;
        md5Bytes[8] |= 0x80;
        return new Java5UUID(md5Bytes);
    }

    public static Java5UUID fromString(String name)
    {
        String components[] = name.split("-");
        if(components.length != 5)
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        for(int i = 0; i < 5; i++)
            components[i] = "0x" + components[i];

        long mostSigBits = Long.decode(components[0]).longValue();
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[1]).longValue();
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[2]).longValue();
        long leastSigBits = Long.decode(components[3]).longValue();
        leastSigBits <<= 48;
        leastSigBits |= Long.decode(components[4]).longValue();
        return new Java5UUID(mostSigBits, leastSigBits);
    }

    public long getLeastSignificantBits()
    {
        return leastSigBits;
    }

    public long getMostSignificantBits()
    {
        return mostSigBits;
    }

    public int version()
    {
        if(version < 0)
            version = (int)(mostSigBits >> 12 & 15L);
        return version;
    }

    public int variant()
    {
        if(variant < 0)
            if(leastSigBits >>> 63 == 0L)
                variant = 0;
            else
            if(leastSigBits >>> 62 == 2L)
                variant = 2;
            else
                variant = (int)(leastSigBits >>> 61);
        return variant;
    }

    public long timestamp()
    {
        if(version() != 1)
            throw new UnsupportedOperationException("Not a time-based UUID");
        long result = timestamp;
        if(result < 0L)
        {
            result = (mostSigBits & 4095L) << 48;
            result |= (mostSigBits >> 16 & 65535L) << 32;
            result |= mostSigBits >>> 32;
            timestamp = result;
        }
        return result;
    }

    public int clockSequence()
    {
        if(version() != 1)
            throw new UnsupportedOperationException("Not a time-based UUID");
        if(sequence < 0)
            sequence = (int)((leastSigBits & 0x3fff000000000000L) >>> 48);
        return sequence;
    }

    public long node()
    {
        if(version() != 1)
            throw new UnsupportedOperationException("Not a time-based UUID");
        if(node < 0L)
            node = leastSigBits & 0xffffffffffffL;
        return node;
    }

    public String toString()
    {
        return digits(mostSigBits >> 32, 8) + "-" + digits(mostSigBits >> 16, 4) + "-" + digits(mostSigBits, 4) + "-" + digits(leastSigBits >> 48, 4) + "-" + digits(leastSigBits, 12);
    }

    private static String digits(long val, int digits)
    {
        long hi = 1L << digits * 4;
        return Long.toHexString(hi | val & hi - 1L).substring(1);
    }

    public int hashCode()
    {
        if(hashCode == -1)
            hashCode = (int)(mostSigBits >> 32 ^ mostSigBits ^ leastSigBits >> 32 ^ leastSigBits);
        return hashCode;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Java5UUID))
            return false;
        if(((Java5UUID)obj).variant() != variant())
        {
            return false;
        } else
        {
            Java5UUID id = (Java5UUID)obj;
            return mostSigBits == id.mostSigBits && leastSigBits == id.leastSigBits;
        }
    }

    public int compareTo(Java5UUID val)
    {
        return mostSigBits >= val.mostSigBits ? mostSigBits <= val.mostSigBits ? leastSigBits >= val.leastSigBits ? ((byte) (((byte)(leastSigBits <= val.leastSigBits ? 0 : 1)))) : -1 : 1 : -1;
    }

    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        version = -1;
        variant = -1;
        timestamp = -1L;
        sequence = -1;
        node = -1L;
        hashCode = -1;
    }

    private static final long serialVersionUID = 0xbc9903f7986d852fL;
    private final long mostSigBits;
    private final long leastSigBits;
    private transient int version;
    private transient int variant;
    private volatile transient long timestamp;
    private transient int sequence;
    private transient long node;
    private transient int hashCode;
    private static volatile SecureRandom numberGenerator = null;

}
