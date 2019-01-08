package com.yy.example.java_base.bitset;

import java.util.BitSet;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018-12-27 at 16:17
 */
public class Test {

    public void get(){
        BitSet bitSet = new BitSet();
        bitSet.set(2);
        System.out.println(bitSet.get(2));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.get();
    }
}
