import java.net.*;

public class CookieManagerPolicyExample {
    public static void main(String[] args) {
        // Create a CookieManager instance
        CookieManager cookieManager = new CookieManager();

        // Set the cookie policy to accept cookies only from the original server
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);



        System.out.println("CookieManager has been set with policy: ACCEPT_ORIGINAL_SERVER");
    }
}
