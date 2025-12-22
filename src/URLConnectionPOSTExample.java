import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionPOSTExample {
    public static void main(String[] args) {
        try {
            // The URL you want to send POST data to
            URL url = new URL("https://httpbin.org/post");

            // Open connection
            URLConnection connection = url.openConnection();

            // Enable writing (POST requires output)
            connection.setDoOutput(true);                // <---- IMPORTANT: Enable output for POST
            connection.setDoInput(true);
            // Disable caches
            connection.setUseCaches(false);

            // Set request properties (headers)
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Prepare POST data
            String postData = "name=John+Doe&email=john@example.com";

            // Write data to output stream
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write(postData);   // Write the data to the output stream
                writer.flush();           // Make sure all data is written
            }

            // Read the response from the server
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                System.out.println("--- Server Response ---");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Print each line of the response
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print any errors
        }
    }
}
