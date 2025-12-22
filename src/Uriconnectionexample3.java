import java.net.URL;
import java.net.URLConnection;

public class Uriconnectionexample3 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a URL object
            URL url = new URL("http://www.oreilly.com/");

            // Step 2: Open a URLConnection
            URLConnection connection = url.openConnection();

            // Step 3: Print the URL
            System.out.println("The URL of the connection is: " + connection.getURL());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
