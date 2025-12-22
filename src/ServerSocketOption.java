import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class ServerSocketOption {
    private static Logger log= Logger.getLogger("request");

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8086);
            ss.setReceiveBufferSize(1024);
            ss.setReceiveBufferSize(1024);
            ss.setReuseAddress(true);
            ss.setSoTimeout(3000);
            Thread.sleep(2000);
        } catch (IOException e) {
            log.warning("Warning"+e.getMessage());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
