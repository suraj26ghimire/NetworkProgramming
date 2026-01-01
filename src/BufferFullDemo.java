import java.nio.ByteBuffer;

public class BufferFullDemo {

    public static void main(String[] args) {

        // 1. Create a ByteBuffer with capacity 10
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println("Initial State");
        printState(buffer);

        // 2. Write data into buffer
        buffer.put((byte) 'H');
        buffer.put((byte) 'I');

        System.out.println("\nAfter Writing Data");
        printState(buffer);

        // 3. Switch buffer from WRITE mode to READ mode
        buffer.flip();

        System.out.println("\nAfter flip()");
        printState(buffer);

        // 4. Read data from buffer
        System.out.println("\nReading Data:");
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }

        System.out.println("\nAfter Reading Data");
        printState(buffer);

        // 5. Clear buffer for reuse
        buffer.clear();

        System.out.println("\nAfter clear()");
        printState(buffer);
    }

    // Method to print buffer state
    private static void printState(ByteBuffer buffer) {
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit   : " + buffer.limit());
        System.out.println("Capacity: " + buffer.capacity());
    }
}