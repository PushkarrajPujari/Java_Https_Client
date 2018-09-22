package me.pujari;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            HttpsClient httpsClient = new HttpsClient("https://localhost:8181/SampleGlassfish/S1");
            httpsClient.getServerCertificate();
            /* System.out.println("-----------------------------------");
            System.out.println("|     Key      ||     Value     |");
            System.out.println("-----------------------------------");
            for(Object key :map.keySet()){
                Object value = map.get(key);
                System.out.println("|     "+key+"      ||     "+value+"     |");
            }*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void firstAttempt() throws IOException {
        URL url = new URL("https://localhost:8181/SampleGlassfish/S1");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }
    public static void secondAttempt() throws IOException {
        String httpsURL = "https://localhost:8181/SampleGlassfish/S1";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }

        br.close();
    }
}
