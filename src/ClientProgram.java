import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientProgram {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6006);
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println("Connected to server.Reading Message");
            String servermessage;
            while((servermessage=in.readLine())!=null)
            {
                System.out.println("server"+servermessage);
            }
            System.out.println("connection closed by server");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
