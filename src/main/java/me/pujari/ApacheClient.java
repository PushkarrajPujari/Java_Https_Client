package me.pujari;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheClient implements IClient{
    private HttpClient client;
    private HttpGet request;
    private  HttpResponse response;

    public ApacheClient(String uri){
        this.client = HttpClientBuilder.create().build();
        this.request = new HttpGet(uri);
    }
    public IClient connect() {
        try{
            response = client.execute(request);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        }
        return this;
    }

    public void getContent() {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
