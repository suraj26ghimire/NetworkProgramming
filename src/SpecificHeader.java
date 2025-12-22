import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;

public class SpecificHeader {
    public static void main(String[] args) {
        try {
            String resource = "https://bytecodealliance.org";
            URL url = new URL(resource);



            URLConnection conn = url.openConnection();
            String contenttype= conn.getHeaderField("Content-Type");
            String transferencoding= conn.getHeaderField("Transfer-Encoding");
            String lastmodified= conn.getHeaderField("Last-Modified");
            System.out.println(contenttype);
            System.out.println(transferencoding);
            System.out.println(lastmodified);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
