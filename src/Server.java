import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket ss =new ServerSocket(6000);
            System.out.println("waiting for client request");
            Socket s=ss.accept();
            System.out.println("connection established");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
