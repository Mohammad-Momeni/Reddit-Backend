package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
            String[] requestParts = request.split("&&");
            if(requestParts[0].equals("login")) {

            }
            else if(requestParts[0].equals("signup")) {
                
            }
            out.close();
            in.close();
            socket.close();
        } catch(IOException e) {}
    }
}
