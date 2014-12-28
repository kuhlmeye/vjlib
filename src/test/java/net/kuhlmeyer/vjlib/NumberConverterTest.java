package net.kuhlmeyer.vjlib;

import junit.framework.TestCase;
import org.junit.Assert;

public class NumberConverterTest extends TestCase {

    public void testConvertShortBytesToInt() throws Exception {
        Assert.assertNull(NumberConverter.convertShortBytesToInt(new short[]{0x00}));
        Assert.assertEquals(Integer.valueOf(0), NumberConverter.convertShortBytesToInt(new short[]{0x00, 0x00}));
        Assert.assertEquals(Integer.valueOf(-8), NumberConverter.convertShortBytesToInt(new short[]{0xF8, 0xFF}));
        Assert.assertEquals(Integer.valueOf(8), NumberConverter.convertShortBytesToInt(new short[]{0x08, 0x00}));
    }

    public void testConvertShortBytesToDouble() throws Exception {
        Assert.assertNull(NumberConverter.convertShortBytesToDouble(new short[]{0xff}, 10d));
        Assert.assertEquals(Double.valueOf(0d), NumberConverter.convertShortBytesToDouble(new short[]{0x00, 0x00}, 10d));
        Assert.assertEquals(Double.valueOf(-0.8d), NumberConverter.convertShortBytesToDouble(new short[]{0xF8, 0xFF}, 10d));
        Assert.assertEquals(Double.valueOf(0.8d), NumberConverter.convertShortBytesToDouble(new short[]{0x08, 0x00}, 10d));
    }

    public void testConvertIntBytesToInt() throws Exception {
        Assert.assertNull(NumberConverter.convertIntBytesToInt(new short[]{0x01, 0x02, 0x03}));
        Assert.assertEquals(Integer.valueOf(305419896), NumberConverter.convertIntBytesToInt(new short[]{0x78, 0x56, 0x34, 0x12}));
        Assert.assertEquals(Integer.valueOf(-305419896), NumberConverter.convertIntBytesToInt(new short[]{0x88, 0xA9, 0xCB, 0xED, 0xFF, 0xFF, 0xFF, 0xFF}));
    }

    public void testConvertIntBytesToDouble() throws Exception {
        Assert.assertNull(NumberConverter.convertIntBytesToDouble(new short[]{0xff}, 10d));
        Assert.assertEquals(Double.valueOf(0d), NumberConverter.convertIntBytesToDouble(new short[]{0x00, 0x00, 0x00, 0x00}, 10d));
        Assert.assertEquals(Double.valueOf(30541989.6d), NumberConverter.convertIntBytesToDouble(new short[]{0x78, 0x56, 0x34, 0x12}, 10d));
        Assert.assertEquals(Double.valueOf(-30541989.6d), NumberConverter.convertIntBytesToDouble(new short[]{0x88, 0xA9, 0xCB, 0xED, 0xFF, 0xFF, 0xFF, 0xFF}, 10d));
    }

    public void testConvertByteToBoolean() throws Exception {
        Assert.assertTrue(NumberConverter.convertByteToBoolean(new short[]{0x01}));
    }

    public void testConvertByteToDouble() throws Exception {
        Assert.assertEquals(Double.valueOf(1.5d), NumberConverter.convertByteToDouble(new short[]{0x0F}, 10d));
        Assert.assertEquals(Double.valueOf(25.5d), NumberConverter.convertByteToDouble(new short[]{0xFF}, 10d));
    }
}