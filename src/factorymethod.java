import java.net.InetAddress;
import java.net.UnknownHostException;

public class factorymethod {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip1= InetAddress.getLocalHost();
        System.out.println(ip1);
        InetAddress ip2=InetAddress.getByName("www.youtube.com");
        System.out.println(ip2);
        InetAddress ip[]=InetAddress.getAllByName("www.google.com");
        for(int i=0; i < ip.length; i++) {
            System.out.println(ip[i]);
        }

    }
}
