import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



public class URLConnectionexample {

    public static void main(String[] args) {
        try{

            URL uri= new URL("https://google.com");
            URLConnection uricon= uri.openConnection();

            String content=uricon.getContentType();
            System.out.println("+++++++"+content);

            long date= uricon.getDate();
            System.out.println("+++++++"+date);


            String contenttype= uricon.getContentType();
            System.out.println("+++++++"+contenttype);
            long  lastmodified= uricon.getLastModified();
            System.out.println("+++++++"+lastmodified);




            InputStream stream= uricon.getInputStream();
            int i;

            while ((i= stream.read())!=-1){
           //     System.out.print((char)i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//