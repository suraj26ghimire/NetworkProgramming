import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class blocktheUri {
    public static void main(String[] args) {
        CookieManager cookieManager= new CookieManager();
        cookieManager.setCookiePolicy(new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                String host= uri.getHost().toLowerCase();
                return!host.endsWith(".gov");


            }
        });
        java.net.CookieHandler.setDefault(cookieManager);
        System.out.println("cookie policy set to block.govCookie");
    }
}
