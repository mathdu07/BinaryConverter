package fr.mathdu07.binary.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitTest
{

    @Test
    public void testByteToBits()
    {
       byte b0 = 0, b1 = 1, b2 = 5, b3 = 15, b4 = -6;
       Bit[] bits0 = Bit.byteToBits(b0), bits1 = Bit.byteToBits(b1), bits2 = Bit.byteToBits(b2), bits3 = Bit.byteToBits(b3), bits4 = Bit.byteToBits(b4);
       
       assertTrue(bits0[0] == Bit.ZERO && bits0[1] == Bit.ZERO && bits0[2] == Bit.ZERO && bits0[3] == Bit.ZERO &&
               bits0[4] == Bit.ZERO && bits0[5] == Bit.ZERO && bits0[6] == Bit.ZERO && bits0[7] == Bit.ZERO);//0 -> 0b00000000
       
       assertTrue(bits1[0] == Bit.ZERO && bits1[1] == Bit.ZERO && bits1[2] == Bit.ZERO && bits1[3] == Bit.ZERO &&
               bits1[4] == Bit.ZERO && bits1[5] == Bit.ZERO && bits1[6] == Bit.ZERO && bits1[7] == Bit.ONE);//1 -> 0b00000001
       
       assertTrue(bits2[0] == Bit.ZERO && bits2[1] == Bit.ZERO && bits2[2] == Bit.ZERO && bits2[3] == Bit.ZERO &&
               bits2[4] == Bit.ZERO && bits2[5] == Bit.ONE && bits2[6] == Bit.ZERO && bits2[7] == Bit.ONE);//5 -> 0b00000101
       
       assertTrue(bits3[0] == Bit.ZERO && bits3[1] == Bit.ZERO && bits3[2] == Bit.ZERO && bits3[3] == Bit.ZERO &&
               bits3[4] == Bit.ONE && bits3[5] == Bit.ONE && bits3[6] == Bit.ONE && bits3[7] == Bit.ONE);//15 -> 0b00001111
       
       assertTrue(bits4[0] == Bit.ONE && bits4[1] == Bit.ONE && bits4[2] == Bit.ONE && bits4[3] == Bit.ONE &&
               bits4[4] == Bit.ONE && bits4[5] == Bit.ZERO && bits4[6] == Bit.ONE && bits4[7] == Bit.ZERO);//-6 -> 0b11111010
    }
    
    @Test
    public void testBitsToString()
    {
        Bit[] b = new Bit[] {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE};
        assertEquals("00011011", Bit.bitsToString(b));
    }
    
    @Test
    public void testEquals()
    {
        Bit[] b0 = new Bit[] {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE};
        Bit[] b1 = new Bit[] {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE};
        Bit[] b2 = new Bit[] {Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE};
        Bit[] b3 = new Bit[] {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE};
        
        assertTrue(Bit.equals(b0, b0));
        assertTrue(Bit.equals(b0, b1));
        assertFalse(Bit.equals(b0, b2));
        assertFalse(Bit.equals(b0, b3));
    }

}
