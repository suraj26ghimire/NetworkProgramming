import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFactorial {
    public static void main(String[] args) {
        try{
            System.out.println("client started");
            Socket s= new Socket("localhost",6009);
            BufferedReader userinput= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter a number");
            int num= Integer.parseInt(userinput.readLine());
            PrintWriter out= new PrintWriter(s.getOutputStream(),true);
            out.println(num);
            BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
