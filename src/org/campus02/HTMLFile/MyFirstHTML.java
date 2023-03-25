package org.campus02.HTMLFile;

import java.io.*;
import java.net.*;


public class MyFirstHTML {
    public static void main(String[] args) {
        String webpageUrl = "https://www.campus02.at";
        String outputFile = "C:\\Users\\postl\\OneDrive\\Dokumente\\Wirtschaftsinformatik\\2. Semester\\Erweiterte Themen der Softwareentwicklung\\HTMLPage\\campus02.html";

        try {
            URL myURL = new URL(webpageUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                String line;

                while ((line = in.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
                bw.flush();

                System.out.println("myUrl.getProtocoll = " + myURL.getProtocol());
                System.out.println("myUrl.getHost() = " + myURL.getHost());
                System.out.println("myURL.getPort() = " + myURL.getPort());
                System.out.println("myURL.getDefaultPort() = " + myURL.getDefaultPort());

                System.out.println("Webpage successfully saved to " + outputFile);
            } catch (IOException e) {
                System.out.println("Error saving webpage to HTML file: " + e.getMessage());
            } finally {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening URL: " + e.getMessage());
        }
    }
}
