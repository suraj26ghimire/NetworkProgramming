import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AddServer {
    public static void main(String[] args) {
        try{
            System.out.println("Waiting for client");
            ServerSocket ss= new ServerSocket(7001);
            Socket s= ss.accept();
            System.out.println("connection established");
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            int num1= Integer.parseInt(in.readLine());
            int num2= Integer.parseInt(in.readLine());
            System.out.println("Received number" +num1+  "and" +num2);
            
            int sum= num1+num2;
            out.println(sum);
            System.out.println("sum of two number=" +sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
