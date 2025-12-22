import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHeader {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://bytecodealliance.org");
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();
            for (int i=1;i<=8;i++){
                System.out.println(huc.getHeaderField(i));
            }
            huc.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
