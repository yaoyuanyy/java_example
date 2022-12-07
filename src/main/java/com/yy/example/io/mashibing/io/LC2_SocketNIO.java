package com.yy.example.io.mashibing.io;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class LC2_SocketNIO {

    /**
     * 缺点：虽然不阻塞了，但是要时刻拿所有的客户端去看看有没有客户端返回了数据
     * 假如有 1000个客户端，只有一个返回了数据，那999个都白判断了
     * 解决方法：多路复用器 select poll epoll 他们都是同步非阻塞io
     * 同步的意思是得自己去内核取数据
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9099));
        ss.configureBlocking(false); //重点  OS  NONBLOCKING!!!

        ss.setOption(StandardSocketOptions.TCP_NODELAY, false);
//        StandardSocketOptions.TCP_NODELAY
//        StandardSocketOptions.SO_KEEPALIVE
//        StandardSocketOptions.SO_LINGER
//        StandardSocketOptions.SO_RCVBUF
//        StandardSocketOptions.SO_SNDBUF
//        StandardSocketOptions.SO_REUSEADDR


        while (true) {
            Thread.sleep(1000);
            SocketChannel client = ss.accept(); //不会阻塞 -1 NULL

            if (client == null) {
                System.out.println("null.....");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client...port: " + port);
                clients.add(client);
            }

            // while 做两个事情，本行以上代码为接受客户端；本行代码以下为处理客户端的数据

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);  //可以在堆里   堆外

            for (SocketChannel c : clients) {   //串行化！！！！  多线程！！
                int num = c.read(buffer);  // >0  -1  0   //不会阻塞
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + " : " + b);
                    buffer.clear();
                }


            }
        }
    }

}
