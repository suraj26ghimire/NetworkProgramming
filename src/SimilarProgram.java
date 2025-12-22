import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimilarProgram {
    public static void main(String[] args) {
        try {
            String resource = "https://bytecodealliance.org";
            URL url = new URL(resource);
            URLConnection conn = url.openConnection();

            Map<String, List<String>> headerFields = conn.getHeaderFields();
            Set<String> keys = headerFields.keySet();

            for (String key : keys) {
                List<String> values = headerFields.get(key);
                System.out.println("Key: " + key);
                for (String value : values) {
                    System.out.println("    " + value);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
