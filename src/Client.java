
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        try{
            System.out.println("client started");
            Socket client=new Socket("localhost",6000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
