package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.Controller;

public class RequestHandler extends Thread {
    private Socket socket;
    RequestHandler (Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            StringBuilder request = new StringBuilder();
            int c = in.read();
            while(c != 0) {
                request.append((char) c);
                c = in.read();
            }
            String response = new Controller().run(request.toString());
            out.writeBytes(response);
            out.flush();
            out.close();
            in.close();
            socket.close();
        } catch(IOException e) {}
    }
}
