import java.net.InetAddress;
import java.security.Key;

public class AnyLocalAddress {
    public static void main(String[] args) {
        try{
            InetAddress add= InetAddress.getByName("www.google.com");
//            InetAddress add=InetAddress.getByName("www.mcglobal.com");
            System.out.println("Name is:"+add.getHostName());
            System.out.println("Address is:"+add.getHostAddress());
            System.out.println(add.isAnyLocalAddress());
            System.out.println(add.isLinkLocalAddress());
            System.out.println(add.isLoopbackAddress());
            System.out.println(InetAddress.getLoopbackAddress());
            System.out.println(add.hashCode());
            System.out.println(add.isMulticastAddress());
            System.out.println(add.isMCGlobal());
            System.out.println(add.isMCOrgLocal());
            System.out.println(add.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
