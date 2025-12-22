import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class LastModified {
    public static void main(String[] args) throws IOException {
        String resource = "https://bytecodealliance.org";
        URL url = new URL(resource);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");
        System.out.println(conn.getLastModified());
        System.out.println(new Date(conn.getLastModified()));
    }
}

