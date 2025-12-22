import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketEx {
    public static void main(String[] args) {
        try{
            SSLSocketFactory factory=(SSLSocketFactory)SSLSocketFactory.getDefault();
            Socket s= factory.createSocket("localhost",1024);
            System.out.println("Server Connected"+s);
            s.close();
         } catch (RuntimeException e) {
            throw new RuntimeException(e);
         } catch (UnknownHostException e) {
            throw new RuntimeException(e);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
    }
}
