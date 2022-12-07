package com.yy.example.io.mashibing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class LC1_SocketBIO {


    /**
     * 终端运行
     * 终端1:
     * 1. cd .java文件目录
     * 2. 编译.java
     * 3. strace -ff -o java SocketBIO
     *
     * 终端2：
     * 1. cd .java文件目录
     * 2. 会发现有 out.xxx 的文件，查看第二个 假如叫：out.1111
     * 3. vim out.1111   :set nu   /9090 端口
     * 3.1 使用动态查看 tail -f out.1111
     *
     * 终端3:
     * nc localhost 9090
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9090,20);

        System.out.println("step1: new ServerSocket(9090) ");

        while (true) {
            Socket client = server.accept();  //阻塞1
            System.out.println("step2:client\t" + client.getPort());

            // 内核会使用 clone 命令创建一个系统级线程
            new Thread(() -> {
                InputStream in = null;
                try {
                    in = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    while(true){
                        // 系统会使用 recv 命令
                        String dataline = reader.readLine(); //阻塞2

                        if(null != dataline){
                        System.out.println(dataline);
                        }else{
                            client.close();
                            break;
                        }
                    }
                    System.out.println("客户端断开");

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }).start();

        }
    }


}
