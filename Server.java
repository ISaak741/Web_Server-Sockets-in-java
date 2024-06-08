package WebServer;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import WebServer.util.Response;

public class Server extends Thread {

    private int appPort;

    public Server(int port) throws Exception {
        this.start();
        appPort = port;
    }

    public void run() {
        try {
            int port = 80;
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server web started at port " + port);
            while (true) {
                Instance client = new Instance(server.accept());
                client.start();

                Socket app = new Socket("localhost", appPort);
                ObjectOutputStream out = new ObjectOutputStream(app.getOutputStream());
                ObjectInputStream inp = new ObjectInputStream(app.getInputStream());

                out.writeObject(client.route);
                out.writeObject(client.headers);
                out.flush();

                Response response = (Response) inp.readObject();
                client.send(response.toString());

            }

        } catch (Exception e) {
            System.out.println("exception occured");
        }
    }

}
