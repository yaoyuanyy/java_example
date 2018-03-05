package com.yy.example.blockchain;

import java.security.MessageDigest;

/**
 * Description:
 * <p></p>
 * <pre>
 *     https://juejin.im/post/5a940b116fb9a0633757587a#comment
 * </pre>
 * NB.
 * Created by skyler on 2018/3/4 at 下午10:38
 */
public class EncodeUtil {

    //应用sha256算法让一个输入转变成256位的hash值
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}