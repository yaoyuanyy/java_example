package com.yy.example.java.io.bio.simple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        OutputStream out = socket.getOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = System.in.read(b)) > 0){
            out.write(b, 0, n);
        }
    }

    /**
     * 接收socket服务器发过来的消息
     * @throws IOException
     */
    public void readResponse() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = inputStream.read(b)) > 0){
            System.out.write(b,0 , n);
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
