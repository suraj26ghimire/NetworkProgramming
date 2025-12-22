import java.net.*;
import java.util.List;
import java.io.IOException;

public class GFGS {

    public static void main(String[] args) throws IOException {

        String uri = "https://stackoverflow.com";


        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);


        CookiePolicy cookiePolicy = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
        cookieManager.setCookiePolicy(cookiePolicy);


        URL url = new URL(uri);
        URLConnection connection = url.openConnection();


        connection.getContent();


        CookieStore cookieStore = cookieManager.getCookieStore();


        List<HttpCookie> cookieList = cookieStore.getCookies();


        for (HttpCookie cookie : cookieList) {
            System.out.println("Domain name: " + cookie.getDomain());
            System.out.println("Cookie name: " + cookie.getName());
            System.out.println("Cookie value: " + cookie.getValue());
            System.out.println("-----------------------------");
        }
    }
}

