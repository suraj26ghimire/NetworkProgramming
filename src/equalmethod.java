import java.net.InetAddress;
import java.net.UnknownHostException;

public class equalmethod {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress ip2=InetAddress.getByName("www.facebook.com");
//        InetAddress ip3=InetAddress.getByName("www.facebook.com");
        InetAddress ip3=InetAddress.getByName("www.ibibo.com");
       System.out.println(ip2.getHostName());
       System.out.println(ip3.getHostName());

       if(ip2.equals(ip3)){
           System.out.println("Both are equal");
       }else{
           System.out.println("Both are not equal");
       }

        }
    }

