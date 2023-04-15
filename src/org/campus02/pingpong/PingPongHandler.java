package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;

public class PingPongHandler {


    private Socket client;

    public PingPongHandler(Socket client) {
        this.client = client;
    }

    public void process() {
        //hier passiert die Logik am Server

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(client.getOutputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {

                switch (line) {
                    case "PONG":
                        bw.write("--> PING");
                        break;
                    case "PING":
                        bw.write("--> PONG");
                        break;
                    default:
                        bw.write("ERROR");
                }
                bw.newLine();
                bw.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

