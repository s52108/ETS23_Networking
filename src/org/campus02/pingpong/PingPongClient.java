package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {
    public static void main(String[] args) {
        try (Socket server = new Socket("localhost", 1111);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(server.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
             BufferedReader cli = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String input;
            while ((input = cli.readLine()) != null) {
                if (input.equals("EXIT")) {
                    break;
                }

            }
/*
            bw.write(input);
            bw.newLine();
            bw.flush();
*/


            String msg = cli.readLine();
            bw.write(msg + "\n");
            bw.flush();
            String reply = br.readLine();
            System.out.println("Server responded with " + reply);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
