import java.net.Socket;

public class LowPortScanner {

    public static void main(String[] args) {
        String host = "127.0.0.1"; // Target IP (localhost)
        int startPort = 20;
        int endPort = 7000;        // Low ports range

        System.out.println("Scanning ports on " + host + "...\n");

        for (int port = startPort; port <= endPort; port++) {
            try {
                // Try to connect to the port
                Socket socket = new Socket(host, port);
                System.out.println("Port " + port + " is OPEN");
                socket.close();
            } catch (Exception e) {
                // Port is closed or not reachable
                // (We do nothing to keep output clean)
            }
        }

        System.out.println("\nScan complete.");
    }
}
