package com.yy.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Random;

/**
 * Created by yaoliang on 2016/12/2.
 */
public class Base64CompareTest {

    private static byte[] randomBinaryData = new byte[5000000];
    private static long durationCommons = 0;
    private static long durationJava8 = 0;
    private static long durationSun = 0;

    private static byte[] encodedCommons;
    private static byte[] encodedJava8;
    private static String encodedSun;

    @BeforeClass
    public static void setUp() throws Exception {

        //We want to test the APIs against the same data
        new Random().nextBytes(randomBinaryData);
    }

    @Test
    public void testSunBase64Encode() throws Exception {
        long before = System.currentTimeMillis();

        encodedSun = Base64.encodeBase64String(randomBinaryData);

        long after = System.currentTimeMillis();
        durationSun = after - before;
        System.out.println("Sun: " + durationSun);
    }

    @Test
    public void testJava8Base64Encode() throws Exception {

        long before = System.currentTimeMillis();

        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        encodedJava8 = encoder.encode(randomBinaryData);

        long after = System.currentTimeMillis();
        durationJava8 = after - before;
        System.out.println("Java8: " + durationJava8);
    }

    @Test
    public void testCommonsBase64Encode() throws Exception {

        long before = System.currentTimeMillis();

        encodedCommons = Base64.encodeBase64(randomBinaryData);

        long after = System.currentTimeMillis();
        durationCommons = after - before;
        System.out.println("Commons: " + durationCommons);
    }

    @AfterClass
    public static void report() throws Exception {

        //Sanity check
        Assert.assertArrayEquals(encodedCommons, encodedJava8);
        System.out.println(durationCommons * 1.0 / durationJava8);
    }
}
