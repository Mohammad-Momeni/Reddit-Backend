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
            String request = in.readUTF();
            String response = new Controller().run(request);
            out.writeUTF(response);
            out.flush();
            out.close();
            in.close();
            socket.close();
        } catch(IOException e) {}
    }
}
