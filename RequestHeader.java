package WebServer;

import java.util.HashMap;
import java.io.BufferedReader;

public class RequestHeader {
    private HashMap<String, String> headers;

    public RequestHeader(BufferedReader request) throws Exception {
        this.headers = new HashMap<>();
        String temp;
        while (!((temp = request.readLine()).isEmpty())) {
            String[] headerParts = temp.split(":");
            this.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    private void put(String key, String val) {
        this.headers.put(key, val);
    }

    public String getVal(String key) {
        return this.headers.get(key);
    }

    public void display() {
        this.headers.forEach((k, v) -> {
            System.out.printf("%s : %s \n", k, v);
        });
    }
}
