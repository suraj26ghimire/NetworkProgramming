import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class FormURLEncodedDemo {
    public static void main(String[] args) {
        try {
            // Original data
            String name = "Suraj Ghimire";
            String email = "suraj.ghimire@234.com";
            String message = "Hello World! How are you?";

            // Encode using application/x-www-form-urlencoded format
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
            String encodedEmail = URLEncoder.encode(email, StandardCharsets.UTF_8);
            String encodedMsg = URLEncoder.encode(message, StandardCharsets.UTF_8);

            // Combine them as key-value pairs
            String formData = "name=" + encodedName +
                    "&email=" + encodedEmail +
                    "&message=" + encodedMsg;

            System.out.println("Original Data:");
            System.out.println(name);
            System.out.println(email);
            System.out.println(message);

            System.out.println("\nX-WWW-FORM-URLENCODED Data:");
            System.out.println(formData);

            // Decode back to original form
            System.out.println("\nDecoded Data:");
            System.out.println(URLDecoder.decode(formData, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
