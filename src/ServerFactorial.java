import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class ServerFactorial {
    public static void main(String[] args) {
        try{
            System.out.println("waiting for client");
            ServerSocket ss= new ServerSocket(6009);
            Socket s= ss.accept();
            System.out.println("connection established");
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            int num= Integer.parseInt(in.readLine());
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            out.println("factorial of"+num+"is :"+calculateFactorial(num));
            System.out.println(calculateFactorial(num));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static long calculateFactorial(int num)
    {
        long fact=1;
        for(int i=1; i<=num; i++)
        {
            fact=fact+i;
        }
        return fact;
    }

}
