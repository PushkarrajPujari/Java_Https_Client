package me.pujari;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("------------ X ------------");
            new ApacheClient("https://google.com").connect().getContent();
            System.out.println("------------ X ------------");
            new HttpsClient("https://google.com").connect().getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
