package me.pujari;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

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

    public IClient getContent() {
        StringBuffer stringBuffer = getMethod(()-> {
            try {
                return response.getEntity().getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        System.out.println(stringBuffer.toString());
        return this;
    }
}
