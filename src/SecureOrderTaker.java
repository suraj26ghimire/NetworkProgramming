import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;
import java.util.Arrays;

public class SecureOrderTaker {

    // Define the port for the server
    public final static int PORT = 50;
    public final static String algorithm = "SSL";

    public static void main(String[] args) {
        try {
            // Initialize SSL context
            SSLContext context = SSLContext.getInstance(algorithm);

            // Create KeyManagerFactory for managing the server's key (private key)
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

            // Create a KeyStore instance to load the server's key and certificate
            KeyStore ks = KeyStore.getInstance("JKS");

            // Load the keystore with password
            char[] password = System.console().readPassword("Enter keystore password: ");
            ks.load(new FileInputStream("jnp4e.keys"), password);  // Keystore file (replace with actual path)
            kmf.init(ks, password);  // Initialize KeyManagerFactory with keystore and password

            // Initialize SSLContext with the KeyManager
            context.init(kmf.getKeyManagers(), null, null);
            Arrays.fill(password, '0');  // Securely erase password from memory

            // Create SSLServerSocketFactory from SSLContext
            SSLServerSocketFactory factory = context.getServerSocketFactory();

            // Create SSLServerSocket to listen on the specified port (7000)
            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);

            // Optional: Enable anonymous cipher suites (if required)
            String[] supported = server.getSupportedCipherSuites();
            String[] anonCipherSuites = Arrays.stream(supported).filter(suite -> suite.contains("_anon_")).toArray(String[]::new);
            server.setEnabledCipherSuites(anonCipherSuites);

            System.out.println("Secure server running on port " + PORT);

            // Accept client connections and handle them in an infinite loop
            while (true) {
                try (Socket theConnection = server.accept()) {
                    // Get input stream from the client connection
                    InputStream in = theConnection.getInputStream();
                    int c;
                    // Read data from client and print to console (or process)
                    while ((c = in.read()) != -1) {
                        System.out.write(c);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
