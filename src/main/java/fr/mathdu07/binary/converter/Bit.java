package fr.mathdu07.binary.converter;

import static java.lang.Math.pow;

//TODO Add function bitsToByte ...
//TODO Add function shortToBits ...
public enum Bit
{
    ZERO((byte) 0),
    ONE((byte) 1);
    
    private final byte value;
    
    Bit(byte value)
    {
        this.value = value;
    }
    
    public byte toByte()
    {
        return value;
    }
    
    public String toString()
    {
        return value == 0 ? "0" : "1";
    }
    
    private static Bit toBit(int i)
    {
        return (i == 0 ? Bit.ZERO : Bit.ONE);
    }
    
    /**
     * 
     * @param value
     * @param size
     * @return the n(size) bits of the given value in big-endian 
     */
    private static Bit[] integerToBits(int value, int size)
    {
        Bit[] bits = new Bit[size];
        
        for (int i = 0; i < size; i++)
            bits[i] = Bit.toBit(value & (int) pow(2, size - (i + 1)));
        
        return bits;
    }
    
    /**
     * 
     * @param b
     * @return the byte's bits in big-endian
     */
    public static Bit[] byteToBits(byte b)
    {        
        return integerToBits(b, 8);
    }
    
    public static String bitsToString(Bit[] bits)
    {
        String str = "";
        
        for (Bit b : bits)
            str += b.toString();
        
        return str;
    }
    
    public static boolean equals(Bit[] bits1, Bit[] bits2)
    {
        if (bits1.length != bits2.length)
            return false;
        
        for (int i = 0; i < bits1.length; i++)
        {
            if (bits1[i] != bits2[i])
                return false;
            else
                continue;
        }
        
        return true;
    }
}
