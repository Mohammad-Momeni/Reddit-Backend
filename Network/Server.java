package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(40404);
        while (true) {
            new RequestHandler(serverSocket.accept()).start();
        }
    }
}
