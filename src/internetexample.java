import java.net.InetAddress;

public class internetexample {
    public static void main(String[] args) {
        try{
            InetAddress ip=InetAddress.getByName("www.asm.edu.np");
            System.out.println("Host name "+ip.getHostName());
            System.out.println("IP address "+ip.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
