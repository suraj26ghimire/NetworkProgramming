import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;

public class MainProgram {

    public static void main(String[] args) throws Exception {

        CacheDemo cache = new CacheDemo();
        ResponseCache.setDefault(cache);

        URL url = new URL("https://example.com/");
        URLConnection conn = url.openConnection();

        // Write data into the CacheDemo's internal request
        OutputStream os = cache.cacheRequest.getBody();
        os.write("Hello Cached World!".getBytes());
        os.close();

        // Trigger the cache to save the data
        cache.put(url.toURI(), conn);

        // Read back from cache
        CacheResponse response = cache.get(url.toURI(), "GET", conn.getRequestProperties());

        if (response != null) {
            InputStream is = response.getBody();
            byte[] data = is.readAllBytes();
            System.out.println("Cached Response: " + new String(data));
        } else {
            System.out.println("Cache miss.");
        }
    }
}
