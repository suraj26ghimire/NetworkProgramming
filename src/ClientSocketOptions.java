import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class ClientSocketOptions {

    public static void main(String[] args) {

        String serverHost = "localhost";
        int serverPort = 5000;

        try (Socket clientSocket = new Socket()) {

            // Set a timeout for connecting (5 seconds)
            clientSocket.connect(new InetSocketAddress(serverHost, serverPort), 5000);

            // Enable/disable TCP_NODELAY (disable Nagle's algorithm)
            clientSocket.setTcpNoDelay(true);

            // Set read timeout (10 seconds)
            clientSocket.setSoTimeout(10000);

            // Set receive buffer size
            clientSocket.setReceiveBufferSize(1024);

            System.out.println("Connected to server: " + clientSocket.getInetAddress());

            // Read data from server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Server says: " + line);
            }

        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
