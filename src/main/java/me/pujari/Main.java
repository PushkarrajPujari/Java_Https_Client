package me.pujari;

public class Main {
  static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
    }
    public static void main(String[] args) {
        try {
            System.setProperty("javax.net.ssl.trustStore", "D:\\KeyStore\\SSL\\cacerts");
            System.out.println(System.getProperty("javax.net.ssl.trustStore"));

            System.out.println("------------ X ------------");
            new ApacheClient("https://google.com").connect().getContent();
            System.out.println("------------ X ------------");
            new HttpsClient("https://google.com").connect().getContent();
            System.out.println("------------ X ------------");

            System.setProperty("javax.net.ssl.trustStore", "D:\\KeyStore\\SSL\\keystore.jks");
            System.out.println(System.getProperty("javax.net.ssl.trustStore"));

            new ApacheClient("https://localhost:8443/SampleTomcat/S1").connect().getContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
