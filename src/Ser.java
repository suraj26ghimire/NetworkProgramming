import java.io.*;
import java.net.*;

public class Ser {
    public static void main(String[] args) {
        int port = 5999; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected.");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine(); // Read message from client
            System.out.println("Received from client: " + message);

            out.println("Hello from server! You said: " + message); // Send response

            clientSocket.close();
            System.out.println("Client disconnected. Server shutting down.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
