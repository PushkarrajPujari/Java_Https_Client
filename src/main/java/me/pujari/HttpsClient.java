package me.pujari;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsClient {
    public void connect(String uri) throws IOException {
        URL url = new URL(uri);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        System.out.printf("Connection - "+con);
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

        String input;

        while ((input = br.readLine()) != null){
            System.out.println(input);
        }
        br.close();
    }
}
