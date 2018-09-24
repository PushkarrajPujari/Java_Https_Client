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
         //new ApacheHttpClient().connect("http://localhost:8084/SampleTomcat/");
         new HttpsClient().connect("https://www.google.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
