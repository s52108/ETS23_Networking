package org.campus02.HTMLFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class HTMLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.at:443");
            String protocol = url.getProtocol();
            String hostname = url.getHost();
            int port = url.getPort();

            System.out.println("Protocol: " + protocol);
            System.out.println("Hostname: " + hostname);
            System.out.println("Port: " + port);

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()));
                 BufferedWriter bw = new BufferedWriter(
                         new FileWriter("C:\\Users\\postl\\OneDrive\\Dokumente\\Wirtschaftsinformatik\\2. Semester\\Erweiterte Themen der Softwareentwicklung\\HTMLPage\\google.html"));

            ) {


                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                    System.out.println(line);
                }
                bw.flush();
            }
        } catch (Exception e) {
            System.out.println("Error reading webpage: " + e.getMessage());
        }
    }
}

