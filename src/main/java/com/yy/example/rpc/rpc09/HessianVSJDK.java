package com.yy.example.rpc.rpc09;

import com.caucho.hessian.io.Hessian2Output;
import com.yy.example.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HessianVSJDK {
    public static void main(String[] args) throws IOException {
        User a = new User(1,"AirSky");

        long b =System.currentTimeMillis();
        byte[] HessianBytes = HessianSerialize(a);
        long c =System.currentTimeMillis();
        System.out.println("HessianLength:"+HessianBytes.length);
        System.out.println("HessianString:"+new String(HessianBytes));
        System.out.println("HessianTime:"+(c-b));

        System.out.println("------------------------------------------------------------------");

        long b1 =System.currentTimeMillis();
        byte[] JdkBytes = JdkSerialize(a);
        long c1 =System.currentTimeMillis();
        System.out.println("JdkLength:"+JdkBytes.length);
        System.out.println("JdkString:"+new String(JdkBytes));
        System.out.println("JdkTime:"+(c1-b1));
    }
    private static byte[] HessianSerialize(Object a) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(a);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;

    }
    private static byte[] JdkSerialize(Object a) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);
        oos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        oos.close();
        return bytes;
    }
}