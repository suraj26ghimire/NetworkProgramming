import java.net.*;

public class CookieManagerNoCookies {
    public static void main(String[] args) {
        // Create a CookieManager instance
        CookieManager cookieManager = new CookieManager();

        // Set the cookie policy to accept NO cookies
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_NONE);

        System.out.println("CookieManager has been set with policy: ACCEPT_NONE");
    }
}
