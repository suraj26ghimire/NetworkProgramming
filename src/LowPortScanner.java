import java.net.Socket;
import java.util.logging.Logger;

public class LowPortScanner {

    private static  Logger log =
            Logger.getLogger("request");

    public static void main(String[] args) {

        String host = "localhost";   // Target host
        int startPort = 1;
        int endPort = 7000;

        log.info("Scanning low ports on host: " + host);
        log.info("-------------------------------------");

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket(host, port);
                log.info("Port " + port + " is OPEN");
                socket.close();
            } catch (Exception e) {
                // Port is CLOSED or FILTERED (ignored)
            }
        }

        log.info("-------------------------------------");
        log.info("Port scanning completed.");
    }
}
