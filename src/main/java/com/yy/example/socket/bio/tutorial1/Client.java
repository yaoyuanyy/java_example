package com.yy.example.socket.bio.tutorial1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
 * Created by skyler on 2018/11/17 at 下午9:52
 */
public class Client {

    private Socket socket;

    public Client(String post, int port) throws IOException {
        this.socket = new Socket(post, port);
    }

    public void sendSystemIn() throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            String msg;
            while ((msg = reader.readLine()) != null){
                writer.println(msg);
                writer.flush();
                System.out.println("客户端发送信息：" + msg);
            }

            reader.close();
            writer.close();
        }catch (Exception e){

        }
    }

    public void sendInfo(String msg) throws IOException {
        try{
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(msg);
            // writer.println(msg);
            // writer.print(msg);
            writer.flush();
            System.out.println("客户端发送信息：" + msg);

            writer.close();
        }catch (Exception e){

        }
    }



    public static void main(String[] args) {
        try {
            Client client = new Client("192.168.0.100", SOCKET_PORT);
            client.sendInfo("c1");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
