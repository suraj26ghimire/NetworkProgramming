import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioSocketServer {

    public static void main(String[] args) throws IOException {

        // Create ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        // Configure non-blocking mode
        serverChannel.configureBlocking(false);

        // Bind to port
        serverChannel.bind(new InetSocketAddress(10));

        System.out.println("Server started on port 10...");

        while (true) {

            // Accept client (non-blocking)
            SocketChannel clientChannel = serverChannel.accept();

            if (clientChannel != null) {
                System.out.println("Client connected");

                // Create buffer
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Read data
                int bytesRead = clientChannel.read(buffer);

                if (bytesRead > 0) {
                    buffer.flip();
                    String msg = new String(buffer.array(), 0, buffer.limit());
                    System.out.println("Received: " + msg);

                    // Write response
                    buffer.clear();
                    buffer.put("Hello Client".getBytes());
                    buffer.flip();
                    clientChannel.write(buffer);
                }

                clientChannel.close();
                System.out.println("Client disconnected");
            }
        }
    }
}