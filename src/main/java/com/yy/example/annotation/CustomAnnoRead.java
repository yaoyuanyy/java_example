package com.yy.example.annotation;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午9:56
 */
public class CustomAnnoRead {

    public static void main(String[] args) {
        Token[] tokens = UserToken.class.getAnnotationsByType(Token.class);
        for (Token token : tokens) {
            System.out.println(token.value());
        }
    }
}
