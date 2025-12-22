import javax.net.ssl.SSLServerSocketFactory;
import java.net.ServerSocket;
import java.net.Socket;

public class SecureSocketEx {
    public static void main(String[] args) {
        try{
            SSLServerSocketFactory factory= (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            ServerSocket serverSocket=factory.createServerSocket(1024);
            Socket s=serverSocket.accept();
            System.out.println(s+"Client Accept and Connected");
            s.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
