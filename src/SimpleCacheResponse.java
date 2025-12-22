import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.List;
import java.util.Map;

public class SimpleCacheResponse extends CacheResponse {

    private final byte[] data;
    private final Map<String, List<String>> headers;

    public SimpleCacheResponse(byte[] data, Map<String, List<String>> headers) {
        this.data = data;
        this.headers = headers;
    }

    @Override
    public Map<String, List<String>> getHeaders() throws IOException {
        return headers;
    }

    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(data);
    }
}
