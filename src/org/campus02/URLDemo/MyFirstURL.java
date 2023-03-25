package org.campus02.URLDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstURL {
    public static void main(String[] args) {
        try {
            //Erzeugung der URL
            URL myURL = new URL("https://www.campus02.at:443");
            try (InputStream inputStream = myURL.openStream();
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(inputStream));) {

                String line;

                while ((line = br.readLine()) != null) {
                    System.out.println("line = " + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
