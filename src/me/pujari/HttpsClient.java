package me.pujari;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpsClient implements X509TrustManager {
    private String httpsUrl;
    private String input;
    private URL url;
    private HttpsURLConnection httpsURLConnection;
    private Map<Object,Object> serverCertificate;
    private BufferedReader bufferedReader;
    private List<String> list;

    public HttpsClient(String httpsUrl) throws IOException {
        System.out.println("Entering Constructor");
        this.httpsUrl = httpsUrl;
        System.out.println("Creating URL instance ... ... ... ");
        this.url = new URL(httpsUrl);
        System.out.println("Opening connection ... ... ... ");
        this.httpsURLConnection = (HttpsURLConnection) url.openConnection();
        System.out.println("Exiting constructor ");
    }

    public void getServerCertificate() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        if(httpsURLConnection != null){
            System.out.println("ResponseCode" + httpsURLConnection.getResponseCode());
            System.out.println("CipherSuite"+ httpsURLConnection.getCipherSuite());
            System.out.println("ServerCertificate"+httpsURLConnection.getServerCertificates());
        }
    }
    public List getServerContent() throws IOException {
        if(httpsURLConnection != null){
            this.bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            this.list = (list!=null)?list:new ArrayList();
            while ((input = bufferedReader.readLine()) != null){
                list.add(input);
            }
        }else{
            if(list == null){
                list = new ArrayList();
            }else {
                list.clear();
            }
        }
        return list;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
