package Network;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            new RequestHandler(serverSocket.accept()).start();
        }
    }
}