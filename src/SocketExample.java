import java.io.IOException;
import java.net.Socket;

public class SocketExample {
    public static void main(String[] args){

        try {
            Socket ss = new Socket("localhost", 3306);
            System.out.println(ss.getInetAddress());
            System.out.println(ss.getLocalPort());
            System.out.println(ss.getPort());
            System.out.println(ss.getLocalAddress());
            ss.setReuseAddress(true);
            ss.setTcpNoDelay(true);
            ss.setKeepAlive(true);
            ss.setSoLinger(true,10);
            ss.setSendBufferSize(1024*1024);
            ss.setReceiveBufferSize(1024*1024);
            ss.setTrafficClass(0*10);
            ss.setSoTimeout(30000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
