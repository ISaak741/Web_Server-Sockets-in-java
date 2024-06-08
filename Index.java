import WebServer.Server;

public class Index {
    public static void main(String[] args) throws Exception {
        new Server(Integer.parseInt(args[0]));
    }
}
