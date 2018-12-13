package com.yy.example.socket.bio.tutorial2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    private Socket socket;

    List<Socket> sockets = new CopyOnWriteArrayList<>();

//    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10
//            , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10)
//            , new BasicThreadFactory.Builder().namingPattern("socket-thread-pool-%d").build());

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void accept() throws IOException {
        while (true) {
            socket = serverSocket.accept();
            sockets.add(socket);
            System.out.println("sockets.size()" + sockets.size());
            new Thread(() -> {
                try {
                    receiveFromClient(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                System.out.println("准备向客服端发送消息...");
                try {
                    sendToClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void receiveFromClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg;
        System.out.println("准备接收客户端的信息...");
        // NB. reader.readLine()是阻塞方法，会停在while这，所以语句(6)永远不会执行到。
        // 所以receiveFromServer(socket)方法不能放在main线程中
        while ((msg = reader.readLine()) != null) {
            System.out.println("收到客户端[" + socket.getInetAddress().getHostAddress() + "]的信息："
                    + msg + " --> current thread" + Thread.currentThread().getName());
        }
    }

    public void sendToClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = reader.readLine()) != null) {
            final String message = msg;
            sockets.forEach(s -> {
                try {
                    PrintWriter writer = new PrintWriter(s.getOutputStream());
                    writer.println(message);
                    writer.flush();
                    System.out.println("服务端信息:" + message + " --> 已发往客户端...:" + s.getInetAddress().getHostAddress());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }


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
