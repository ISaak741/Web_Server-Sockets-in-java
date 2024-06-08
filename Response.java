package WebServer.util;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private String reponseCode;
    private HashMap<String, String> responseHeader = new HashMap<>();
    private String responseData;

    public void setResponseHeader(String key, String val) {
        this.responseHeader.put(key, val);
    }

    public void setResponseCode(int val) {
        this.reponseCode = "HTTP/1.1 OK " + val;
    }

    public void setResponseData(String data) {
        this.responseData = data;
    }

    public String toString() {
        StringBuilder resp = new StringBuilder();
        resp.append(reponseCode).append("\r\n").append("\r\n");

        for (Map.Entry<String, String> set : responseHeader.entrySet())
            resp.append(set.getKey()).append(": ").append(set.getValue()).append("\r\n");

        resp.append("\r\n").append(responseData).append("\r\n");
        return resp.toString();
    }

}
