package WebServer;

public class Route {
    public String method;
    public String urlPath;

    public Route(String url) {
        String[] urlParts = url.split(" ");
        this.method = urlParts[0];
        this.urlPath = urlParts[1];
    }

    public String toString() {
        return String.format("method : %s \nurl-path: %s \n", this.method, this.urlPath);
    }
}