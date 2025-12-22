import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        int port = 6000; // Server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("DateTime Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle each client in a new thread
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Thread class for handling clients
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            // Get current date and time
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = formatter.format(new Date());

            out.println("Current server date and time: " + dateTime);
            System.out.println("Sent date/time to client: " + socket.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Client disconnected: " + socket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
