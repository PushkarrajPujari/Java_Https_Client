package me.pujari;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpsClient implements IClient{
    private URL url;
    private HttpsURLConnection connection;

    public HttpsClient(String uri) throws MalformedURLException {
        this.url = new URL(uri);
    }
    public IClient connect() {
        try{
            connection = (HttpsURLConnection)url.openConnection();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println("Response Code : "+connection.getResponseCode());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return this;
    }

    public Object getContent() {
        StringBuffer stringBuffer = getMethod(()->{
            try {
                return connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        System.out.println(stringBuffer.toString());
        return null;
    }
}
