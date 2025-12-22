import java.net.CookieManager;
import java.net.CookiePolicy;


public class GFG {

    public static void main(String[] args) {

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);



        System.out.println("CookieManager successfully created and policy set to ACCEPT_ALL.");
    }
}

