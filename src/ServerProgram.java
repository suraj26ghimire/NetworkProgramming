import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(6006);
            System.out.println("connection.established waiting for client");
            Socket s=ss.accept();
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            out.println("Hello client, this message is from server");
            out.println("Today date is"+new java.util.Date());
            out.println("goodbye client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
