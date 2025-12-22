import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class CacheDemo extends ResponseCache {

    SimpleCacheRequest cacheRequest = new SimpleCacheRequest();
    private byte[] savedData = null;

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        savedData = cacheRequest.getData();   // Save data from request body
        return cacheRequest;
    }

    @Override
    public CacheResponse get(URI uri, String requestMethod,
                             Map<String, List<String>> requestHeaders) throws IOException {

        if (savedData == null) return null;

        return new SimpleCacheResponse(savedData, requestHeaders);
    }
}
