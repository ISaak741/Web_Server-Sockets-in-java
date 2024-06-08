import java.io.BufferedInputStream;
import java.io.FileInputStream;

package WebServer;

public class DefaultFileRenderer {
    private String fileName;
    private BufferedInputStream file;

    public DefaultFileRenderer(String name) {
        this.fileName = name;
    }

    public byte[] render() throws Exception {
        this.file = new BufferedInputStream(new FileInputStream(this.fileName));
        return this.file.readAllBytes();
    }
}
