import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class SimpleCacheRequest extends CacheRequest {

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private boolean aborted = false;

    @Override
    public OutputStream getBody() throws IOException {
        return buffer;
    }

    @Override
    public void abort() {
        aborted = true;
    }

    public byte[] getData() {
        return aborted ? null : buffer.toByteArray();
    }
}
