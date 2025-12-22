import java.io.*;
import java.net.*;

public class SourceViewer4 {

    public static void main(String[] args) {

        // HARD-CODED URL HERE
        String[] urls = {
                "https://example.com"   // <<< YOU CAN CHANGE THIS
        };

        for (int i = 0; i < urls.length; i++) {
            try {
                URL u = new URL(urls[i]);
                HttpURLConnection uc = (HttpURLConnection) u.openConnection();

                int code = uc.getResponseCode();
                String response = uc.getResponseMessage();
                System.out.println("HTTP/1.x " + code + " " + response);

                for (int j = 1; ; j++) {
                    String header = uc.getHeaderField(j);
                    String key = uc.getHeaderFieldKey(j);
                    if (header == null && key == null) break;
                    if (key != null) {
                        System.out.println(key + ": " + header);
                    }
                }

                System.out.println();

                try (InputStream in = new BufferedInputStream(uc.getInputStream());
                     Reader r = new InputStreamReader(in)) {

                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }

            } catch (MalformedURLException ex) {
                System.err.println(urls[i] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println("I/O Error: " + ex.getMessage());
            }

            System.out.println("\n---------------------------------------------\n");
        }
    }
}
