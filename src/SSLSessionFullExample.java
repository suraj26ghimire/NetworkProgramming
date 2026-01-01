
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLSessionFullExample {

    public static void main(String[] args) {

        String host = "www.example.com";
        int port = 443;


        try {
            // Create SSL socket
            SSLSocketFactory factory =
                    (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket =
                    (SSLSocket) factory.createSocket(host, port);

            // Start SSL handshake
            socket.startHandshake();

            // Get SSL session
            SSLSession session = socket.getSession();

            // 1️⃣ getId()
            byte[] sessionId = session.getId();
            System.out.println("Session ID: " +
                    Arrays.toString(sessionId));

            // 2️⃣ getSessionContext()
            SSLSessionContext context = session.getSessionContext();
            System.out.println("Session Context: " + context);

            // 3️⃣ getCreationTime()
            System.out.println("Creation Time: " + session.getCreationTime());

            // 4️⃣ getLastAccessedTime()
            System.out.println("Last Accessed Time: " + session.getLastAccessedTime());

            // 5️⃣ getCipherSuite()
            System.out.println("Cipher Suite: " + session.getCipherSuite());

            // 6️⃣ getPeerHost()
            System.out.println("Peer Host: " + session.getPeerHost());

            // 7️⃣ putValue()
            session.putValue("user", "student");
            session.putValue("role", "client");

            // 8️⃣ getValue()
            System.out.println("User: " + session.getValue("user"));

            // 9️⃣ getValueNames()
            System.out.println("Stored Session Values:");
            for (String name : session.getValueNames()) {
                System.out.println(" - " + name);
            }

            // 🔟 removeValue()
            session.removeValue("role");

            // 1️⃣1️⃣ getPeerCertificates()
            try {
                Certificate[] certs = session.getPeerCertificates();
                System.out.println("Server Certificates:");

                for (Certificate cert : certs) {
                    if (cert instanceof X509Certificate x509) {
                        System.out.println(
                                "Subject: " +
                                        x509.getSubjectX500Principal()
                        );
                    }
                }
            } catch (SSLPeerUnverifiedException e) {
                System.out.println("Peer not verified");
            }

            // 1️⃣2️⃣ invalidate()
            session.invalidate();
            System.out.println("Session invalidated");

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}