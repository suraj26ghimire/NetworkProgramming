import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientLocalPortScanner {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress remote = InetAddress.getLocalHost();
        String hostname = remote.getHostName();

        System.out.println("Scanning ports on: " + hostname +
                " (" + remote.getHostAddress() + ")");

        for (int port = 1; port <= 2000; port++) {
            try {
                Socket s = new Socket(remote, port);
                System.out.println("A server is listening on port " + port +
                        " of " + hostname);
                s.close();
            } catch (IOException ex) {
                // Port is closed, ignore
            }
        }
    }
}
