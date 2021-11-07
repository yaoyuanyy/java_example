package com.yy.example.java.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by yaoliang on 2016/12/2.
 */
public class Base64Test {

    public static void main(String args[]){
        try {

            String original = "TutorialsPoint?java8";
            System.out.println("Original String: " + original);

            // Encode using basic encoder;
            String encodedString = Base64.getEncoder().encodeToString(original.getBytes("utf-8"));
            System.out.println("Encoded String (Basic) :" + encodedString);
            // Decode
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String original2 = new String(decodedBytes, "utf-8");
            System.out.println("Decoded String (Basic) :" + original2);

            encodedString = Base64.getUrlEncoder().encodeToString(original.getBytes("utf-8"));
            System.out.println("Encoded String (URL) :" + encodedString);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Encoded String (MIME) :" + mimeEncodedString);

          

        }catch(UnsupportedEncodingException e){
            System.out.println("Error :" + e.getMessage());
        }
    }
}
