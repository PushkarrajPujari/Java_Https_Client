package me.pujari;

public class Main {

    public static void main(String[] args) {
        try {
         new ApacheClient("https://google.com").connect().getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
