package com.yy.example.rpc.rpc01;

import com.yy.example.rpc.common.IUserService;
import com.yy.example.rpc.common.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("server started");
        while (running) {
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        System.out.println("server socket closing");
        ss.close();
    }

    private static void process(Socket s) throws Exception {
        InputStream in = s.getInputStream();
        System.out.println("server socket s.getInputStream is blocked");
        DataInputStream dis = new DataInputStream(in);

        int id = dis.readInt();
        IUserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        System.out.println("server socket findUserById");

        OutputStream out = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
        System.out.println("server socket data flushed");

    }
}
