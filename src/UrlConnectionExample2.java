import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionExample2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://google.com");
            URLConnection conn = url.openConnection();
            System.out.println("URL: " + conn.getURL());

            conn.setDoInput(true);
            System.out.println("DoInput: " + conn.getDoInput());


            conn.setDoOutput(false);
            System.out.println("DoOutput: " + conn.getDoOutput());


            long time = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
            conn.setIfModifiedSince(time);
            System.out.println("IfModifiedSince: " + conn.getIfModifiedSince());


            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("\n---- Web Content ----");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
