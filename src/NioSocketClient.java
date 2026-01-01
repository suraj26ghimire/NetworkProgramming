import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioSocketClient {

    public static void main(String[] args) throws IOException {

        // Create SocketChannel
        SocketChannel socketChannel = SocketChannel.open();

        // Configure non-blocking
        socketChannel.configureBlocking(false);

        // Connect to server
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 10));

        // Finish connection
        while (!socketChannel.finishConnect()) {
            System.out.println("Connecting...");
        }

        System.out.println("Connected to server");

        // Send message
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello Server".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        // Read response
        buffer.clear();
        socketChannel.read(buffer);
        buffer.flip();

        System.out.println("Server says: " +
                new String(buffer.array(), 0, buffer.limit()));

        socketChannel.close();
    }
}