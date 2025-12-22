import java.io.*;
import java.net.*;

public class Cli {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server IP
        int port = 5999; // Server port

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server.");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String messageToServer = "Hello Server!";
            out.println(messageToServer); // Send message
            System.out.println("Sent to server: " + messageToServer);

            String response = in.readLine(); // Receive response
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
