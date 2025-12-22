import java.net.*;

public class ReadHeadersExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            URLConnection connection = url.openConnection();

            connection.connect();  // optional but clearer

            System.out.println("---- Header Information ----");

            // Loop through all headers
            for (int i = 0; ; i++) {
                String headerName = connection.getHeaderFieldKey(i);
                String headerValue = connection.getHeaderField(i);

                if (headerName == null && headerValue == null) {
                    break; // no more headers
                }

                System.out.println((headerName != null ? headerName : "Status")
                        + ": " + headerValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
