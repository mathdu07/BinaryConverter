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
    public void testShortToBits()
    {
    	short s0 = 0, s1 = 1254, s2 = -652;
    	Bit[] bits0 = Bit.shortToBits(s0), bits1 = Bit.shortToBits(s1), bits2 = Bit.shortToBits(s2);
    	
    	assertEquals("0000000000000000", Bit.bitsToString(bits0));
    	assertEquals("0000010011100110", Bit.bitsToString(bits1));
    	assertEquals("1111110101110100", Bit.bitsToString(bits2));
    }
    
    @Test
    public void testIntToBits()
    {
    	int i0 = 454364810, i1 = -145345, i2 = 25439;
    	
    	assertEquals("00011011000101010000111010001010", Bit.bitsToString(Bit.intToBits(i0)));
    	assertEquals("11111111111111011100100000111111", Bit.bitsToString(Bit.intToBits(i1)));
    	assertEquals("00000000000000000110001101011111", Bit.bitsToString(Bit.intToBits(i2)));
    }
    
    @Test
    public void testLongToBits()
    {
    	long l0 = 8526841, l1 = -584654145156641120l, l2 = 95614514513115l;
    	
    	System.out.println(Long.toBinaryString(l2));
    	assertEquals("0000000000000000000000000000000000000000100000100001101111111001", Bit.bitsToString(Bit.longToBits(l0)));
    	assertEquals("1111011111100010111001000010011100010001011110101000111010100000", Bit.bitsToString(Bit.longToBits(l1)));
    	assertEquals("0000000000000000010101101111010111111101001011000100010011011011", Bit.bitsToString(Bit.longToBits(l2)));
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
    
    @Test
    public void testToByte()
    {
    	assertTrue(Bit.ZERO.toByte() == 0);
    	assertTrue(Bit.ONE.toByte() == 1);
    }

}
