import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel client = SocketChannel.open();
        client.configureBlocking(false);

        client.connect(new InetSocketAddress("127.0.0.1", 11));

        while (!client.finishConnect()) {
            System.out.println("Connecting...");
        }

        System.out.println("Connected to server");

        String message = "Hello Server";
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(message.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        client.write(buffer);
        buffer.clear();

        Thread.sleep(1000);

        int bytesRead = client.read(buffer);
        if (bytesRead > 0) {
            buffer.flip();
            String response = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("Server says: " + response);
        }

        client.close();
    }
}
