package com.yy.example.socket.bio.simple.v2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.yy.example.socket.bio.Constants.SOCKET_PORT;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB. 开始我遇到一个问题，服务端收不到客服端的信息，把我气的啊。后来知道了原因：BufferedReader.readLine()与PrintWriter.writer() or print()这是个大坑。
 *   readLine()需要得到换行符出现，而writer() and print()都不没有换行，改成println()立马收到信息了
 * </pre>
 * <p>
 * Created by skyler on 2018/11/15 at 上午11:13
 */
public class ServerSocketDemo {

    private ServerSocket serverSocket;

    public ServerSocketDemo(int port) throws IOException {
        // 创建一个ServerSocket并指定监听接口
        serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        // 开始接受客户端连接
        Socket client = serverSocket.accept();
        handleClient(client);
    }

    public void handleClient(Socket socket) throws IOException {
        // 使用socket进行通信
        // tcp是全双工通信，读入和写出彼此不受影响
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        System.out.println("正在等待接收客服端信息...");

        String msg;
        while ((msg = reader.readLine()) != null){
            writer.println(msg);
            writer.flush();
            System.out.println("收到客户端的信息：" + msg+" --> 正在回传...");
        }
    }

    public static void main(String[] args) {

        try {
            ServerSocketDemo serverSocketDemo = new ServerSocketDemo(SOCKET_PORT);
            serverSocketDemo.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
