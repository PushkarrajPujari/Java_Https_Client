package me.pujari;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsClient implements IClient{
    public IClient connect() {
        try{
            URL url = new URL("");
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
        }catch (Exception e){
            e.printStackTrace();
        }
    return null;
    }

    public void getContent() {

    }
}
