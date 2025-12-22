import java.net.ServerSocket;
import java.util.logging.Logger;

public class LocalPortScanner {
    private static Logger log= Logger.getLogger("request");
    public static void main(String[] args){
        for(int port=1; port<=6000;port++)
        try{
            ServerSocket ss= new ServerSocket(port);

        } catch (Exception e) {
           log.info("Information"+e.getMessage());
           log.warning("warning");
        }
    }
}
