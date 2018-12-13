package com.yy.example.socket.bio.tutorial1;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.yy.example.socket.bio.Constants.SOCKET_PORT;

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
public class Server {

    private ServerSocket serverSocket;

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10
            , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10)
            , new BasicThreadFactory.Builder().namingPattern("socket-thread-pool-%d")
            .uncaughtExceptionHandler((t, e) ->{
                System.out.println("thread:"+t.getName() + " exception:"+e.getMessage());
            }).build());

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void accept() throws IOException {
        while (true) {
            System.out.println("准备接收，马上创建新线程...");
            Socket socket = serverSocket.accept();
            executor.execute(() -> {
                try {
                    handleAccept(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        }
    }

    private void handleAccept(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg;
        System.out.println("准备接收客户端的信息...");
        while ((msg = reader.readLine()) != null) {
            System.out.println("收到客户端[" + socket.getInetAddress().getHostAddress() + "]的信息："
                    + msg + " --> current thread" + Thread.currentThread().getName());
        }
        reader.close();
    }



    public static void main(String[] args) {
        try {
            Server server = new Server(SOCKET_PORT);
            server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
