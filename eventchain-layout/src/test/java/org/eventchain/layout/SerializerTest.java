package org.eventchain.layout;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.ByteBuffer;

import static org.testng.Assert.assertEquals;

public class SerializerTest {

    private Layout<TestBean> layout;
    private Serializer<TestBean> serializer;
    private Deserializer<TestBean> deserializer;

    private static class TestBean {

        @Getter @Setter
        private byte pByte;
        @Getter @Setter
        private Byte oByte;

        @Getter @Setter
        private byte[] pByteArr;
        @Getter @Setter
        private Byte[] oByteArr;

        @Getter @Setter
        private short pShort;
        @Getter @Setter
        private Short oShort;

        @Getter @Setter
        private int pInt;
        @Getter @Setter
        private Integer oInt;

        @Getter @Setter
        private long pLong;
        @Getter @Setter
        private Long oLong;

        @Getter @Setter
        private float pFloat;
        @Getter @Setter
        private Float oFloat;

        @Getter @Setter
        private double pDouble;
        @Getter @Setter
        private Double oDouble;

        @Getter @Setter
        private boolean pBoolean;
        @Getter @Setter
        private Boolean oBoolean;

        @Getter @Setter
        private char pChar;
        @Getter @Setter
        private Character oChar;


    }

    @BeforeClass
    @SneakyThrows
    public void setUp() {
        layout = new Layout<>(TestBean.class);
        serializer = new Serializer<>(layout);
        deserializer = new Deserializer<>(layout);
    }

    @Test
    public void byteSerialization() {
        TestBean test = new TestBean();
        test.setPByte(Byte.MIN_VALUE);
        test.setOByte(Byte.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Byte.MIN_VALUE, deserialized.getPByte());
        assertEquals((Byte)Byte.MAX_VALUE, deserialized.getOByte());
    }

    @Test
    public void byteArraySerialization() {
        TestBean test = new TestBean();
        test.setPByteArr(new byte[]{Byte.MIN_VALUE});
        test.setOByteArr(new Byte[]{Byte.MAX_VALUE});

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(new byte[]{Byte.MIN_VALUE}, deserialized.getPByteArr());
        assertEquals(new Byte[]{Byte.MAX_VALUE}, deserialized.getOByteArr());
    }

    @Test
    public void shortSerialization() {
        TestBean test = new TestBean();
        test.setPShort(Short.MIN_VALUE);
        test.setOShort(Short.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Short.MIN_VALUE, deserialized.getPShort());
        assertEquals((Short)Short.MAX_VALUE, deserialized.getOShort());
    }

    @Test
    public void intSerialization() {
        TestBean test = new TestBean();
        test.setPInt(Integer.MIN_VALUE);
        test.setOInt(Integer.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Integer.MIN_VALUE, deserialized.getPInt());
        assertEquals((Integer)Integer.MAX_VALUE, deserialized.getOInt());
    }

    @Test
    public void longSerialization() {
        TestBean test = new TestBean();
        test.setPLong(Long.MIN_VALUE);
        test.setOLong(Long.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Long.MIN_VALUE, deserialized.getPLong());
        assertEquals((Long)Long.MAX_VALUE, deserialized.getOLong());
    }

    @Test
    public void floatSerialization() {
        TestBean test = new TestBean();
        test.setPFloat(Float.MIN_VALUE);
        test.setOFloat(Float.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Float.MIN_VALUE, deserialized.getPFloat());
        assertEquals(Float.MAX_VALUE, deserialized.getOFloat());
    }

    @Test
    public void doubleSerialization() {
        TestBean test = new TestBean();
        test.setPDouble(Double.MIN_VALUE);
        test.setODouble(Double.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Double.MIN_VALUE, deserialized.getPDouble());
        assertEquals(Double.MAX_VALUE, deserialized.getODouble());
    }

    @Test
    public void booleanSerialization() {
        TestBean test = new TestBean();
        test.setPBoolean(true);
        test.setOBoolean(false);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(true, deserialized.isPBoolean());
        assertEquals((Boolean)false, deserialized.getOBoolean());
    }

    @Test
    public void charSerialization() {
        TestBean test = new TestBean();
        test.setPChar(Character.MIN_VALUE);
        test.setOChar(Character.MAX_VALUE);

        ByteBuffer buffer = serializer.serialize(test);

        buffer.rewind();
        TestBean deserialized = new TestBean();
        deserializer.deserialize(deserialized, buffer);

        assertEquals(Character.MIN_VALUE, deserialized.getPChar());
        assertEquals((Character)Character.MAX_VALUE, deserialized.getOChar());
    }
}