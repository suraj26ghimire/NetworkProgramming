import java.net.*;
import java.util.List;

public class Cookie {

    public static void main(String[] args) {
        // Create a CookieManager and get its CookieStore
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create cookies
        HttpCookie cookieA = new HttpCookie("c1", "ram");
        HttpCookie cookieB = new HttpCookie("c2", "sita");
        HttpCookie cookieC = new HttpCookie("c3", "hari");

        // Create URIs
        URI url1 = URI.create("https://www.facebook.com");
        URI url2 = URI.create("https://www.youtube.com");

        // Add cookies to the CookieStore
        cookieStore.add(url1, cookieA);
        cookieStore.add(url2, cookieB);
        cookieStore.add(null, cookieC);

        // Display all cookies
        List<HttpCookie> cookieList = cookieStore.getCookies();
        System.out.println("All cookies: " + cookieList);

        // Remove one cookie
        cookieStore.remove(url1, cookieA);
        List<HttpCookie> remainingCookies = cookieStore.getCookies();
        System.out.println("After removing one cookie: " + remainingCookies);

        // Remove all cookies
        cookieStore.removeAll();
        List<HttpCookie> emptyCookieList = cookieStore.getCookies();
        System.out.println("After removing all cookies: " + emptyCookieList);
    }
}
