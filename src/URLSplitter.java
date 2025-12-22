import java.net.URL;

public class URLSplitter {

    public static void main(String[] args) {
        try {
            // Sample URL
            String urlString = "https://www.example.com:8080/products/list?id=123&sort=asc#section2";

            URL url = new URL(urlString);

            System.out.println("URL: " + urlString);
            System.out.println("------------------------------");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref (Anchor): " + url.getRef());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
