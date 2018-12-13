package com.yy.example.socket.bio.simple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.yy.example.socket.bio.Constants.SOCKET_PORT;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
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
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = in.read(b)) > 0){
            out.write(b, 0, n);
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
