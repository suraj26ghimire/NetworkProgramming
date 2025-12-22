import java.net.URL;

public class ConstructURLDemo {

    public static void main(String[] args) {
        try {
            // Constructing URL with protocol, host, and file
            URL url1 = new URL("https", "www.example.com", "/index.html");
            System.out.println("URL 1: " + url1);

            // Constructing URL with protocol, host, port, and file
            URL url2 = new URL("http", "www.example.com", 8080, "/page.html");
            System.out.println("URL 2: " + url2);

            // Constructing URL from a full string
            URL url3 = new URL("https://www.google.com/search?q=java");
            System.out.println("URL 3: " + url3);

            // Constructing URL using a base URL and relative path
            URL base = new URL("https://www.example.com/folder/");
            URL url4 = new URL(base, "image.png");
            System.out.println("URL 4: " + url4);

        } catch (Exception e) {
            System.out.println("Error constructing URL: " + e.getMessage());
        }
    }
}
