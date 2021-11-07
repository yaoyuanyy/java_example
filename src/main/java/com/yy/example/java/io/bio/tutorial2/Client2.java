package com.yy.example.java.io.bio.tutorial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.yy.example.java.io.bio.Constants.SOCKET_PORT;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/17 at 下午9:52
 */
public class Client2 {

    private Socket socket;

    public Client2(String post, int port) throws IOException {
        this.socket = new Socket(post, port);
    }

    public void run() throws IOException {
        new Thread(() -> {
            try {
                send(socket);
            } catch (Exception e) {

            }
        }).start();
        System.out.println("-----走到这了");
        new Thread(() -> {
            try {
                rev(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void send(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("准备向服务端发送信息...");
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        String msg;
        // NB. reader.readLine()是阻塞方法，会停在while这，所以语句(6)永远不会执行到。
        // 所以send(socket)方法不能放在main线程中
        while ((msg = reader.readLine()) != null) {
            writer.println(msg);
            writer.flush();
            System.out.println("客户端发送信息：" + msg);
        }
        //(6)
        System.out.println("while out");
    }

    public void rev(Socket socket) throws IOException {
        System.out.println("开始异步获取服务端的消息...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg;
        while ((msg = reader.readLine()) != null) {
            System.out.println("我是客户端：" + socket.getLocalAddress().getHostAddress() + ", 收到来自服务器端的消息：" + msg);
        }
    }

    public static void main(String[] args) {
        try {
            Client2 client2 = new Client2("localhost", SOCKET_PORT);
            client2.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
