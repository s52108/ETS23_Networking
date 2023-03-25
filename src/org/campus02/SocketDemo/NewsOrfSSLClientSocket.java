package org.campus02.SocketDemo;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewsOrfSSLClientSocket {
    public static void main(String[] args) {
        try (Socket socket = SSLSocketFactory.
                getDefault().
                createSocket("news.orf.at", 443);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
            bw.flush();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            new ServerSocket(2056);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}