import java.net.ServerSocket;
import java.util.logging.Logger;

public class RandomPort {
    private static Logger log = Logger.getLogger("request");

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(0);
            log.info("The server runs on port " + ss.getLocalPort());
            ss.close();
        } catch (Exception e) {
            log.info("Information: " + e.getMessage());
        }
    }
}

