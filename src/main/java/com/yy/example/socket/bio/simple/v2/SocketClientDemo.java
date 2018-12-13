package com.yy.example.socket.bio.simple.v2;

import java.io.*;
import java.net.Socket;

import static com.yy.example.socket.bio.Constants.SOCKET_PORT;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB. PrintWriter的println方法自动添加换行，BufferedWriter需要显示调用newLine方法；
 * </pre>
 * <p>
 * Created by skyler on 2018/11/15 at 上午11:48
 */
public class SocketClientDemo {

    private Socket socket;

    public SocketClientDemo(String host, int port) throws IOException {
        // 创建socket并连接服务器
        this.socket = new Socket(host, port);
    }

    /**
     * 和服务器端进行通信
     * @throws IOException
     */
    public void run() throws IOException {
        // 异步接收socket服务器发过来的消息
        new Thread(() -> {
            try {
                readResponse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // 读取控制台文本，发给sorket服务端
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        /**
         * PrintWriter的println方法自动添加换行，BufferedWriter需要显示调用newLine方法；
         * BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         * bufferedWriter.newLine();
         */
        String msg;
        while ((msg = reader.readLine()) !=null){
            writer.println(msg);
            writer.flush();
            System.out.println("来自终端的信息:" + msg + " --> 已发往服务端...");
        }
    }

    /**
     * 接收socket服务器发过来的消息
     * @throws IOException
     */
    public void readResponse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("正在等待接收服务端信息...");
        String msg;
        while ((msg = reader.readLine()) !=null){
            System.out.println("收到服务端发来的信息："+msg);
        }
    }

    public static void main(String[] args) {
        try {
            SocketClientDemo clientDemo = new SocketClientDemo("localhost", SOCKET_PORT);
            clientDemo.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
