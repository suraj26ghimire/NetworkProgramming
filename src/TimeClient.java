import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TimeClient {

    public static void main(String[] args) {

        try (
                Socket s = new Socket("time.nist.gov", 13);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(s.getInputStream(), StandardCharsets.US_ASCII))
        ) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Local Time: " + new Date());

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
