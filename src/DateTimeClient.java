import java.io.*;
import java.net.*;

public class DateTimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String serverMessage = in.readLine(); // Receive date/time
            System.out.println("Server says: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
