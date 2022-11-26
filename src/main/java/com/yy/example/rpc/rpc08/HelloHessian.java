package com.yy.example.rpc.rpc08;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.yy.example.rpc.common.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HelloHessian {
    public static void main(String[] args) throws IOException {
        User a = new User(4,"AirSky");
        byte[] bytes = serialize(a);
        System.out.println(bytes.length);
        User a1 = (User)deserialize(bytes);
        System.out.println(a1);
    }

    private static byte[] serialize(User a) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(a);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;

    }
    private static Object deserialize(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }
}