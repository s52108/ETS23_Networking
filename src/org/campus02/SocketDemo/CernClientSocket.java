package org.campus02.SocketDemo;

import java.io.*;
import java.net.Socket;

public class CernClientSocket {
    public static void main(String[] args) {
        try (Socket socket = new Socket("info.cern.ch", 80);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: info.cern.ch \r\n\r\n");
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
