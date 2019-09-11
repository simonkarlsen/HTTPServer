package no.kristiania;

import java.io.IOException;
import java.net.Socket;

public class ClientHTTP {

    private String host;
    private String requestTarget;

    public ClientHTTP(String host, String requestTarget) {
        this.host = host;
        this.requestTarget = requestTarget;

    }

    public static void main(String[] args) throws IOException {
        new ClientHTTP("urlecho.appspot.com", "/echo?status=200&Content-Type=text%2Fhtml&body=Hello%20world!").executeRequest();


    }

    public HttpClientResponse executeRequest() throws IOException {
        try(Socket socket = new Socket(host, 80)) { //try-with-resource closes Socket

            socket.getOutputStream().write(("GET " + requestTarget + " HTTP/1.1\r\n").getBytes());
                socket.getOutputStream().write(("Host:" + host + "\r\n").getBytes());
                socket.getOutputStream().write("Connection: close\r\n".getBytes());
                socket.getOutputStream().write("\r\n".getBytes());
                socket.getOutputStream().flush();

                HttpClientResponse httpClientResponse = new HttpClientResponse(socket);
                httpClientResponse.invoke();
                return httpClientResponse;


//            new HttpClientResponse(socket).invoke();
        }
    }

}
