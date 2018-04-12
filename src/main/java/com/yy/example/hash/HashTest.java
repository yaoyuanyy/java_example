package com.yy.example.hash;

/**
 * Description:
 * <p></p>
 * <pre>
 *     refer to:
 *     https://juejin.im/post/5accb0e0518825556a72bf11?utm_medium=be&utm_source=weixinqun
 * </pre>
 * NB.
 * Created by skyler on 2018/4/12 at 上午11:43
 */
public class HashTest {

    public static void main(String[] args) {
        String key = "test";
        int keyHash = 20; //key.hashCode();
        System.out.printf("keyHash:%d\n",keyHash);

        int hash16 = keyHash >>> 2;
        System.out.printf("hash16:%d\n",hash16);

        int keyHash2 = keyHash ^ hash16;
        System.out.printf("keyHash2:%d",keyHash2);

    }
}
