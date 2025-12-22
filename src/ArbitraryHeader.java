import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

public class ArbitraryHeader {
    public static void main(String[] args) {
        try {
            String resource = "https://bytecodealliance.org";
            URL url = new URL(resource);
            URLConnection conn = url.openConnection();
            conn.connect();

            String headerField = conn.getHeaderField(5);
            String headerKey = conn.getHeaderFieldKey(5);
            System.out.println(headerKey + ": " + headerField);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
