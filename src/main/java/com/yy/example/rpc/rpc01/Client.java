package com.yy.example.rpc.rpc01;

import com.yy.example.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 8888);
        System.out.println("socket start");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);
        System.out.println("start writeInt 123");

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();
        System.out.println("socket flush");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);

        System.out.println(user);

        dos.close();
        s.close();
    }
}