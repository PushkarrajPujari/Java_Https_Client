package me.pujari;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Baeldung {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        Integer port = 8443;
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(host, port);
        InputStream in = sslsocket.getInputStream();
        OutputStream out = sslsocket.getOutputStream();

        out.write(1);

        while (in.available() > 0) {
            System.out.print(in.read());
        }

        System.out.println("Secured connection performed successfully");
    }
}
