package fr.mathdu07.binary.converter;

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
}
