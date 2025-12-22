import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try{
            System.out.println("waiting for client");
            ServerSocket ss= new ServerSocket(8001);
            Socket s= ss.accept();
            System.out.println("connection established");
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            BufferedReader consoleinput= new BufferedReader(new InputStreamReader(System.in));
            String clientmsg, servermsg;


            while((clientmsg=in.readLine())!=null)
            {
                System.out.println(clientmsg);
                servermsg=consoleinput.readLine();
                out.print(servermsg);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
