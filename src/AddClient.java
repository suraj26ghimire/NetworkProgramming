import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AddClient {
    public static void main(String[] args) {
        try
        {
            System.out.println("client started");
            Socket s= new Socket("localhost",7001);
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out= new PrintWriter(s.getOutputStream(),true);
            System.out.println("connected to server");
            System.out.println("enter a number1");
            int num1= Integer.parseInt(userinput.readLine());
            System.out.println("enter a number2");
            int num2= Integer.parseInt(userinput.readLine());
            out.println(num1);
            out.println(num2);
            System.out.println(in.readLine());

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
