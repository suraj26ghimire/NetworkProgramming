import java.net.Socket;
import java.net.UnknownHostException;
import java.net.SocketException;
import java.io.IOException;

public class ClientSocketInfo {

    public static void main(String[] args) {

        String urlhost = "spm.com.np"; // take only URL/domain

        try {
            Socket theSocket = new Socket(urlhost, 80);

            System.out.println("Connected to: " + theSocket.getInetAddress());
            System.out.println("On port: " + theSocket.getPort());
            System.out.println("From port: " + theSocket.getLocalPort());
            System.out.println("Of: " + theSocket.getLocalAddress());

            theSocket.close();

        } catch (UnknownHostException ex) {
            System.err.println("I can't find " + urlhost);
        } catch (SocketException ex) {
            System.err.println("Could not connect to " + urlhost);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
