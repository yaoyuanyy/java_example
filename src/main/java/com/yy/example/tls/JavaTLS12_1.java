package com.yy.example.tls;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/**
 * Description:
 * <pre>
 *  refer to https://docs.oracle.com/javase/10/security/sample-code-illustrating-secure-socket-connection-client-and-server.htm#JSSEC-GUID-B9103D0C-3E6A-4301-B558-461E4CB23DC9
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-22 at 16:59
 */
public class JavaTLS12_1 {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) throws Exception {
        try {
            SSLSocketFactory factory =
                    (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket =
                    (SSLSocket) factory.createSocket("www.baidu.com", 443);

            socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @SneakyThrows
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("CipherSuite: " + handshakeCompletedEvent.getCipherSuite());
//                    System.out.println("getPeerCertificates: " + gson.toJson(handshakeCompletedEvent.getPeerCertificates()));
                    System.out.println("getSession: " + gson.toJson(handshakeCompletedEvent.getSession()));
//                    System.out.println("getPeerCertificateChain: " + gson.toJson(handshakeCompletedEvent.getPeerCertificateChain()));
                }
            });

            /*
             * send http request
             *
             * Before any application data is sent or received, the
             * SSL socket will do SSL handshaking first to set up
             * the security attributes.
             *
             * SSL handshaking can be initiated by either flushing data
             * down the pipe, or by starting the handshaking by hand.
             *
             * Handshaking is started manually in this example because
             * PrintWriter catches all IOExceptions (including
             * SSLExceptions), sets an internal error flag, and then
             * returns without rethrowing the exception.
             *
             * Unfortunately, this means any error messages are lost,
             * which caused lots of confusion for others using this
             * code.  The only way to tell there was an error is to call
             * PrintWriter.checkError().
             */
            socket.startHandshake();

            System.out.println("------------------ https response --------------------------");
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream())));

            out.println("GET / HTTP/1.0");
            out.println();
            out.flush();

            /*
             * Make sure there were no surprises
             */
            if (out.checkError())
                System.out.println(
                        "SSLSocketClient:  java.io.PrintWriter error");

            /* read response */
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
