import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
           try
           {
               System.out.println("client started");
               Socket s= new Socket("localhost",8001);
               BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
               PrintWriter out=new PrintWriter(s.getOutputStream(),true);
               BufferedReader consoleinput= new BufferedReader(new InputStreamReader(System.in));
               String servermsg, clientmsg;
               while(true)
               {
                   System.out.println("client");
                   clientmsg=consoleinput.readLine();
                   out.print(clientmsg);
                   servermsg=in.readLine();
                   if(servermsg==null)
                       break;
                   System.out.println(servermsg);

               }
           } catch (Exception e) {

               e.printStackTrace();
           }

    }
}
