package fr.mathdu07.binary.converter;

import static java.lang.Math.pow;

//TODO Add function bitsToByte ...
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
    
    private static Bit toBit(long i)
    {
        return (i == 0 ? Bit.ZERO : Bit.ONE);
    }
    
    /**
     * 
     * @param value
     * @param size
     * @return the n(size) bits of the given value in big-endian 
     */
    private static Bit[] integerToBits(long value, int size)
    {
        Bit[] bits = new Bit[size];
        
        for (int i = 0; i < size; i++)
        {
        	if (i == 0)
        		bits[i] = (value < 0) ? Bit.ONE : Bit.ZERO;
        	else
        		bits[i] = Bit.toBit(value & (long) pow(2, size - (i + 1)));
        }
        
        return bits;
    }
    
    /**
     * 
     * @param b
     * @return the byte's 8 bits in big-endian
     */
    public static Bit[] byteToBits(byte b)
    {        
        return integerToBits(b, 8);
    }
    
    /**
     * 
     * @param value
     * @return the short's 16 bits in big-endian
     */
    public static Bit[] shortToBits(short value)
    {
    	return integerToBits(value, 16);
    }
    
    /**
     * 
     * @param value
     * @return int's 32 bits in big-endian
     */
    public static Bit[] intToBits(int value)
    {
    	return integerToBits(value, 32);
    }
    
    /**
     * 
     * @param value
     * @return long's 64 bits in big-endian
     */
    public static Bit[] longToBits(long value)
    {
    	return integerToBits(value, 64);
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
