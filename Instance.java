package WebServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Instance extends Thread {
    public Socket handler;
    public RequestHeader headers;
    public Route route;

    public Instance(Socket client) throws Exception {
        this.handler = client;
    }

    public void run() {
        try {
            BufferedReader requestPacket = new BufferedReader(new InputStreamReader(handler.getInputStream()));
            this.route = new Route(requestPacket.readLine());
            this.headers = new RequestHeader(requestPacket);
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    public void send(String result) throws Exception {
        this.handler.getOutputStream().write(result.getBytes());
        this.handler.getOutputStream().flush();
    }
}
