package org.campus02.SocketDemo;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;


public class OrfClientSocket {
    public static void main(String[] args) {
        try (Socket socket = SSLSocketFactory.getDefault().createSocket("news.orf.at", 443);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: news.orf.at \r\n\r\n");
            bw.flush();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}