package no.kristiania.HTTPServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket socket = serverSocket.accept();

            int c;

            while ((c = socket.getInputStream().read()) != -1) {
                System.out.print((char) c);


            }

        }
}
