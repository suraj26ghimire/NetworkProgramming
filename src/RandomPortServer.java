// Write a program for getting information about a server socket

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class RandomPortServer {
    private static Logger log= Logger.getLogger("request");

    public static void main(String[] args) {
        try{
            ServerSocket ss= new ServerSocket(0);
            InetAddress inetAddress= ss.getInetAddress();
            log.info("Port Number" +ss.getLocalPort());
            log.info("InetAddress"+inetAddress.getHostAddress());
            log.info("CanocinalHostName"+inetAddress.getCanonicalHostName());
            log.info("HostName"+inetAddress.getHostName());

        } catch (Exception e) {
            log.warning("Warning"+e.getMessage());
        }
    }

}
